// lib/screens/pantalla_detalle_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../models/empleado_nomina_mp.dart';

class PantallaDetalle extends StatelessWidget {
  final String          id;
  final EmpleadoNomina? empleado; // puede venir por extras

  const PantallaDetalle({super.key, required this.id, this.empleado});

  @override
  Widget build(BuildContext context) {
    // Si no viene por extras, buscar en la lista simulada
    final emp = empleado ??
        empleadosSimulados.where((e) => e.id == id).firstOrNull;

    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Detalle: ${emp?.nombre ?? id}'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: emp == null
          ? Center(child: Text('Empleado $id no encontrado'))
          : Padding(
              padding: const EdgeInsets.all(16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  _Fila('ID',       emp.id),
                  _Fila('Nombre',   emp.nombre),
                  _Fila('Código',   emp.codigoNomina),
                  _Fila('N° emp.',  emp.numeroEmpleado.toString()),
                  _Fila('IESS',     emp.afiliadoIess ? 'Afiliado' : 'No afiliado'),
                  const SizedBox(height: 24),
                  Row(children: [
                    OutlinedButton.icon(
                      onPressed: () => context.pop(),
                      icon:  const Icon(Icons.arrow_back),
                      label: const Text('Volver'),
                    ),
                    const SizedBox(width: 12),
                    FilledButton.icon(
                      onPressed: () => context.push('/empleados/${emp.id}/historial'),
                      icon:  const Icon(Icons.list_alt),
                      label: const Text('Ver historial'),
                    ),
                  ]),
                ],
              ),
            ),
    );
  }
}

class _Fila extends StatelessWidget {
  final String label;
  final String valor;
  const _Fila(this.label, this.valor);

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 6),
      child: Row(children: [
        SizedBox(
          width: 70,
          child: Text(label,
              style: TextStyle(color: cs.onSurfaceVariant,
                  fontWeight: FontWeight.w600, fontSize: 12)),
        ),
        Text(valor, style: const TextStyle(fontSize: 15)),
      ]),
    );
  }
}
