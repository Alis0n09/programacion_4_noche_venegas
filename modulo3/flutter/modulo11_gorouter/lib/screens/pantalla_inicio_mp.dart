// lib/screens/pantalla_inicio_mp.dart
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Sistema de Nómina'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Icon(Icons.badge, size: 64, color: cs.primary),
            const SizedBox(height: 16),
            const Text('Dashboard de Nómina',
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
            const SizedBox(height: 8),
            Text('Gestiona a tus empleados',
                style: TextStyle(color: cs.onSurfaceVariant)),
            const SizedBox(height: 32),
            FilledButton.icon(
              // context.go() — navega SIN apilar (no hay botón "atrás")
              onPressed: () => context.go('/empleados'),
              icon:  const Icon(Icons.badge),
              label: const Text('Ver empleados'),
            ),
          ],
        ),
      ),
    );
  }
}
