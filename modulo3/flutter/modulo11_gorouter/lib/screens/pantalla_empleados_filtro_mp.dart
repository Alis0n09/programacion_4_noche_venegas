// lib/screens/pantalla_empleados_filtro_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../models/empleado_nomina_mp.dart';

class PantallaEmpleadosFiltro extends StatelessWidget {
  final bool soloIess;
  const PantallaEmpleadosFiltro({super.key, this.soloIess = false});

  @override
  Widget build(BuildContext context) {
    final filtrados = soloIess
        ? empleadosSimulados.where((e) => e.afiliadoIess).toList()
        : empleadosSimulados;

    return Scaffold(
      appBar: AppBar(
        title:   Text('Empleados${soloIess ? ' (IESS)' : ''}'),
        actions: [
          // Toggle filtro IESS — cambia la URL con query param
          IconButton(
            icon:    Icon(soloIess ? Icons.verified_user : Icons.people_outline),
            tooltip: soloIess ? 'Ver todos' : 'Solo afiliados IESS',
            onPressed: () => soloIess
                ? context.go('/empleados')
                : context.go('/empleados?soloIess=true'),
          ),
        ],
      ),
      body: ListView.builder(
        itemCount:   filtrados.length,
        itemBuilder: (context, i) {
          final e = filtrados[i];
          return ListTile(
            leading: Icon(Icons.badge, color: e.afiliadoIess ? Colors.green : Colors.grey),
            title:   Text(e.nombre),
            subtitle: Text(e.codigoNomina),
            onTap: () => context.push(
              '/empleados/${e.id}',
              extra: e,   // pasa el objeto completo
            ),
          );
        },
      ),
    );
  }
}
