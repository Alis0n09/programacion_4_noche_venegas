// lib/screens/pantalla_empleados_mp.dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:modulo10_riverpod/models/empleado_nomina_mp.dart';
import '../providers/empleados_provider_mp.dart';

class PantallaEmpleados extends ConsumerWidget {
  const PantallaEmpleados({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final empleados = ref.watch(empleadosProvider);
    final cs         = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Empleados (${empleados.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: empleados.isEmpty
          ? const Center(child: Text('Sin empleados'))
          : ListView.separated(
              itemCount:        empleados.length,
              separatorBuilder: (_, __) =>
                  const Divider(height: 1, indent: 72),
              itemBuilder: (context, i) {
                final e = empleados[i];
                return ListTile(
                  leading: CircleAvatar(
                    backgroundColor: e.afiliadoIess
                        ? Colors.green.shade50
                        : Colors.grey.shade100,
                    child: Icon(Icons.badge,
                        color: e.afiliadoIess ? Colors.green : Colors.grey),
                  ),
                  title:    Text(e.nombre,
                      style: const TextStyle(fontWeight: FontWeight.w600)),
                  subtitle: Text('${e.codigoNomina} · #${e.numeroEmpleado}'),
                  trailing: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      IconButton(
                        icon: Icon(
                          e.prioritario ? Icons.star : Icons.star_border,
                          color: e.prioritario ? Colors.amber : null,
                        ),
                        onPressed: () => ref
                            .read(empleadosProvider.notifier)
                            .togglePrioritario(e.id),
                      ),
                      IconButton(
                        icon: const Icon(Icons.delete_outline,
                            color: Colors.red),
                        onPressed: () => ref
                            .read(empleadosProvider.notifier)
                            .eliminar(e.id),
                      ),
                    ],
                  ),
                );
              },
            ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          final id = DateTime.now().millisecondsSinceEpoch.toString();
          ref.read(empleadosProvider.notifier).agregar(
            EmpleadoNomina(
              id:             id,
              nombre:         'nuevo-empleado-$id',
              codigoNomina:   '012.003.001.${empleados.length + 1}',
              numeroEmpleado: 22,
              afiliadoIess:   true,
            ),
          );
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}
