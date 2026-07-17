// lib/main_mp.dart
import 'package:flutter/material.dart';
import 'widgets/tarjeta_log_mp.dart';
import 'widgets/fila_estado_mp.dart';
import 'widgets/avatar_badge_mp.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  Container — decoración y espaciado                  │
// │  2  Paso 2  Column — TarjetaLog (bitácora de nómina)            │
// │  3  Paso 3  Row + Expanded + Spacer — FilaEstado (empleados)    │
// │  4  Paso 4  Stack + Positioned — AvatarBadge (empleados)        │
// │  5  Paso 5  SizedBox, Padding, Align, Wrap                      │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 5;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  home: switch (paso) {
     1 => _paso1(),
     2 => Scaffold(
      body: ListView(
        children: [
          TarjetaLog(nivel: 'ERROR', componente: 'calculo-nomina',
              mensaje:   'IESS rechazó el aporte del empleado EMP-0045',
              timestamp: DateTime.now()),
          TarjetaLog(nivel: 'WARN',  componente: 'roles-pago',
              mensaje:   '3 empleados sin cuenta bancaria registrada',
              timestamp: DateTime.now().subtract(const Duration(minutes: 2))),
          TarjetaLog(nivel: 'INFO',  componente: 'cierre-mensual',
              mensaje:   'Rol de pagos de julio generado correctamente',
              timestamp: DateTime.now().subtract(const Duration(minutes: 5))),
          TarjetaLog(nivel: 'DEBUG', componente: 'validador-horas',
              mensaje:   'Revisión de horas extra completada (120ms)',
              timestamp: DateTime.now().subtract(const Duration(minutes: 8))),
        ],
      ),
    ),
     3 => const Scaffold(
      body: Column(
        children: [
          FilaEstado(nombre: 'Gabriela Calderón', detalle: 'Vendedora · \$1.200,00', activo: true),
          Divider(height: 1),
          FilaEstado(nombre: 'Jorge Vera',        detalle: 'Bodeguero · \$650,00',    activo: true),
          Divider(height: 1),
          FilaEstado(nombre: 'Mateo Alba',        detalle: 'Vacaciones · sin pago este mes', activo: false),
          Divider(height: 1),
          FilaEstado(nombre: 'Ana María Chiluisa Quinatoa',
                     detalle: '\$980,00 · afiliada IESS', activo: true),
        ],
      ),
    ),
     4 => const Scaffold(
      body: Center(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            AvatarBadge(nombre: 'Gabriela', pendientes: 2,  activo: true,  detalle: 'Gabriela'),
            SizedBox(width: 24),
            AvatarBadge(nombre: 'Jorge',    pendientes: 0,  activo: true,  detalle: 'Jorge'),
            SizedBox(width: 24),
            AvatarBadge(nombre: 'Mateo',    pendientes: 0,  activo: false, detalle: 'Mateo'),
            SizedBox(width: 24),
            AvatarBadge(nombre: 'Ana',      pendientes: 11, activo: true,  detalle: 'Ana'),
            SizedBox(width: 24),
            AvatarBadge(nombre: 'DETALLE',  pendientes: 0,  activo: true,  detalle: 'MATEO ALBA'),
          ],
        ),
      ),
    ),
     5 => Scaffold(
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [
          const Text('SizedBox', style: TextStyle(fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          const Text('Primer elemento'),
          const SizedBox(height: 32),
          const Text('Segundo elemento (después de 32px)'),

          const Divider(height: 32),

          const Text('Padding', style: TextStyle(fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          Container(
            color: Colors.indigo.shade50,
            child: const Padding(
              padding: EdgeInsets.only(left: 24),
              child:   Text('Rol de pagos con Padding izquierdo'),
            ),
          ),

          const Divider(height: 32),

          const Text('Align', style: TextStyle(fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          const Align(
            alignment: Alignment.centerRight,
            child: Icon(Icons.settings, color: Colors.indigo),
          ),

          const Divider(height: 32),

          const Text('Wrap', style: TextStyle(fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          Wrap(
            spacing:    8,
            runSpacing: 8,
            children: ['Rol de pagos', 'IESS', 'Décimo tercero', 'Vacaciones',
                       'Horas extra', 'Fondo de reserva', 'Multa']
                .map((t) => Chip(label: Text(t)))
                .toList(),
          ),
        ],
      ),
    ),
      _ => Scaffold(body: Center(child: Text('Paso $paso: crea el widget primero'))),
  },
));

// ─── Paso 1 — Container (vive aquí en main.dart) ─────────────────────
Widget _paso1() => Scaffold(
  body: Center(
    child: Container(
      width:     double.infinity,
      height:    80,
      margin:    const EdgeInsets.all(24),
      padding:   const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
      decoration: BoxDecoration(
        color:        Colors.indigo.shade50,
        borderRadius: BorderRadius.circular(40),
        border:       Border(left: BorderSide(color: Colors.indigo, width: 4)),
        boxShadow: [
          BoxShadow(
            color:      Colors.black.withOpacity(0.3),
            blurRadius: 8,
            offset:     const Offset(0, 2),
          ),
        ],
      ),
      child: const Text('Empleado: Gabriela Calderón',
          style: TextStyle(fontWeight: FontWeight.bold)),
    ),
  ),
);
