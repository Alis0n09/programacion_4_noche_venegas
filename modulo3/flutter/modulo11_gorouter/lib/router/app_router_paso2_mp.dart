// lib/router/app_router_paso2_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../screens/pantalla_inicio_mp.dart';
import '../screens/pantalla_empleados_mp.dart';
import '../screens/pantalla_detalle_mp.dart';
import '../models/empleado_nomina_mp.dart';

final appRouterPaso2Mp = GoRouter(
  initialLocation: '/',
  debugLogDiagnostics: true,
  routes: [
    GoRoute(
      path:    '/',
      builder: (context, state) => const PantallaInicio(),
    ),
    GoRoute(
      path:    '/empleados',
      builder: (context, state) => const PantallaEmpleados(),
      routes: [
        // Ruta hija: /empleados/:id
        GoRoute(
          path:    ':id',   // relativa — ruta completa: /empleados/:id
          builder: (context, state) {
            final id       = state.pathParameters['id']!;
            final empleado = state.extra as EmpleadoNomina?;
            return PantallaDetalle(id: id, empleado: empleado);
          },
        ),
        // Ruta hija: /empleados/:id/historial
        GoRoute(
          path:    ':id/historial',
          builder: (context, state) {
            final id = state.pathParameters['id']!;
            return Scaffold(
              appBar: AppBar(title: Text('Historial de $id')),
              body:   Center(child: Text('Historial de pagos del empleado $id')),
            );
          },
        ),
      ],
    ),
  ],
);
