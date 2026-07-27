// lib/main_mp.dart
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:modulo11_gorouter/router/app_router_paso2_mp.dart';
import 'package:modulo11_gorouter/router/app_router_paso3_mp.dart';
import 'package:modulo11_gorouter/router/app_router_paso4_mp.dart';
import 'router/app_router_mp.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  Rutas básicas + context.go / push / pop             │
// │  2  Paso 2  pathParameters + pantalla de detalle                │
// │  3  Paso 3  queryParameters + extras + ShellRoute               │
// │  4  Paso 4  ShellRoute completo + NavigationBar persistente     │
// │  5  Paso 5  Guard redirect + pantalla de login + Riverpod       │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 4;

void main() {
  runApp(
    ProviderScope(
      child: AppNomina(paso: paso),
    ),
  );
}

class AppNomina extends StatelessWidget {
  final int paso;
  const AppNomina({super.key, required this.paso});

  @override
  Widget build(BuildContext context) {
    final router = switch (paso) {
      1 => appRouterMp,
      2 => appRouterPaso2Mp,
      3 => appRouterPaso3Mp,
      4 => appRouterPaso4Mp,/*
      5 => appRouterPaso5(context),*/
      _ => appRouterMp,
    };

    return MaterialApp.router(
      title:        'Sistema de Nómina',
      debugShowCheckedModeBanner: false,
      routerConfig: router,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: const Color(0xFF0D47A1)),
        useMaterial3: true,
      ),
    );
  }
}
