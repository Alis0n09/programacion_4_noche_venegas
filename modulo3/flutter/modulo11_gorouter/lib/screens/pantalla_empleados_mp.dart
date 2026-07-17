// lib/screens/pantalla_empleados_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:modulo11_gorouter/models/empleado_nomina_mp.dart';

class PantallaEmpleados extends StatelessWidget {
  const PantallaEmpleados({super.key});

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;
    final empleados = empleadosSimulados;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Empleados'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: ListView.builder(
        itemCount:   empleados.length,
        itemBuilder: (context, i) => ListTile(
          leading: const Icon(Icons.badge),
          title:   Text(empleados[i].nombre),
          onTap: () {
            // context.push() — apila la pantalla (aparece botón "atrás")
            // Navegar con extras — pasa el objeto completo evitando una segunda búsqueda
            context.push(
              '/empleados/${empleados[i].id}',
              extra: empleados[i],   // EmpleadoNomina completo
            );
          },
        ),
      ),
    );
  }
}
