// lib/router/app_router_paso4_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../screens/scaffold_con_nav_mp.dart';
import '../screens/pantalla_empleados_mp.dart';
import '../screens/pantalla_detalle_mp.dart';
import '../screens/pantalla_metricas_mp.dart';
import '../screens/pantalla_ajustes_mp.dart';
import '../models/empleado_nomina_mp.dart';

final appRouterPaso4Mp = GoRouter(
  initialLocation: '/empleados',
  debugLogDiagnostics: true,
  routes: [
    // ShellRoute — mantiene ScaffoldConNav vivo entre rutas hijas
    ShellRoute(
      builder: (context, state, child) => ScaffoldConNav(child: child),
      routes: [
        GoRoute(
          path:    '/empleados',
          builder: (_, __) => const PantallaEmpleados(),
          routes: [
            GoRoute(
              path:    ':id',
              builder: (context, state) {
                final id       = state.pathParameters['id']!;
                final empleado = state.extra as EmpleadoNomina?;
                return PantallaDetalle(id: id, empleado: empleado);
              },
            ),
          ],
        ),
        GoRoute(
          path:    '/metricas',
          builder: (_, __) => const PantallaMetricas(),
        ),
        GoRoute(
          path:    '/ajustes',
          builder: (_, __) => const PantallaAjustes(),
        ),
      ],
    ),
  ],
);
