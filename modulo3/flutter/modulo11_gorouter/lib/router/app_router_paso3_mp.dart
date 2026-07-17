// lib/router/app_router_paso3_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../screens/pantalla_inicio_mp.dart';
import '../screens/pantalla_empleados_filtro_mp.dart';
import '../screens/pantalla_detalle_mp.dart';
import '../models/empleado_nomina_mp.dart';

final appRouterPaso3Mp = GoRouter(
  initialLocation: '/',
  routes: [
    GoRoute(
      path:    '/',
      builder: (context, state) => const PantallaInicio(),
    ),
    GoRoute(
      path:    '/empleados',
      builder: (context, state) {
        // Query parameters — /empleados?soloIess=true
        final soloIess = state.uri.queryParameters['soloIess'] == 'true';
        return PantallaEmpleadosFiltro(soloIess: soloIess);
      },
    ),
    GoRoute(
      path:    '/empleados/:id',
      builder: (context, state) {
        final id       = state.pathParameters['id']!;
        final empleado = state.extra as EmpleadoNomina?;
        return PantallaDetalle(id: id, empleado: empleado);
      },
    ),
  ],
);
