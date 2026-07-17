// lib/main_mp.dart
import 'package:flutter/material.dart';
import 'package:modulo06_widgets/widgets/contador_limitado_mp.dart';
import 'package:modulo06_widgets/widgets/etiqueta_mp.dart';
import 'package:modulo06_widgets/widgets/indicador_mp.dart';
import 'package:modulo06_widgets/widgets/pantalla_contexto_mp.dart';
import 'package:modulo06_widgets/widgets/reloj_mp.dart';
import 'package:modulo06_widgets/widgets/servicio_estado_mp.dart';
import 'widgets/catalogo_basicos_mp.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1   StatelessWidget mínimo                             │
// │  2  Paso 1b  Widgets básicos — catálogo (nómina)                │
// │  3  Paso 2   StatelessWidget con parámetros (estados de rol)    │
// │  4  Paso 3   StatefulWidget / setState / proceso de nómina      │
// │  5  Paso 3b  Parámetros en StatefulWidget (topes de horas)      │
// │  6  Paso 4   Ciclo de vida con Timer (control de asistencia)    │
// │  7  Paso 5   BuildContext                                        │
// │  8  Paso 6   Composición de widgets (KPIs de nómina)            │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 1;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  theme: ThemeData(
    colorScheme:  ColorScheme.fromSeed(
      seedColor:  const Color.fromARGB(255, 150, 0, 130),          // ← cambia aquí
      brightness: Brightness.light,     // ← Brightness.dark para modo oscuro
    ),
    useMaterial3: true,
  ),
  home: switch (paso) {
    1 => const Scaffold(body: Center(child: Saludo())),
    2 => const CatalogoBasicos(),
    3 => const Scaffold(
      body: Center(
        child: Wrap(
          spacing:    12,
          runSpacing: 8,
          children: [
            Etiqueta(texto: 'Aprobado',  color: Colors.green),
            Etiqueta(texto: 'Rechazado', color: Colors.red,    relleno: true),
            Etiqueta(texto: 'Pendiente', color: Colors.orange),
            Etiqueta(texto: 'Urgente',   color: Colors.red,    fontSize: 16, relleno: true),
            Etiqueta(texto: 'Info',      color: Colors.blue,   fontSize: 11),
          ],
        ),
      ),
    ),
    4 => const Scaffold(
      body: Center(
        child: ProcesoNomina(nombre: 'rol-pagos-quincenal-enero'),
      ),
    ),
    5 => Scaffold(                               // Paso 3b
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ContadorLimitado(
              etiqueta: 'Horas extra del mes',
              limite:   40,
              color:    Colors.red,
              onLimite: () => debugPrint('¡Tope de horas extra alcanzado!'),
            ),
            const SizedBox(height: 40),
            ContadorLimitado(
              etiqueta: 'Vacantes por cubrir',
              limite:   10,
              color:    Colors.indigo,
            ),
          ],
        ),
      ),
    ),
    6 => Scaffold(                              // Paso 4
      appBar: AppBar(title: const Text('Control de asistencia')),
      body: const Center(child: Reloj()),
    ),
    7 => const PantallaContexto(),
    8 => Scaffold(                             // Paso 6
      body: Center(
        child: Wrap(
          spacing:    32,
          runSpacing: 24,
          alignment:  WrapAlignment.center,
          children: const [
            Indicador(label: 'Empleados activos',  valor: '45',
                      color: Colors.green, icono: Icons.badge),
            Indicador(label: 'Nóminas con error',   valor: '2',
                      color: Colors.red,   icono: Icons.warning_amber,
                      subtitulo: 'Requieren atención'),
            Indicador(label: 'Total planilla',      valor: '\$12.450',
                      color: Colors.indigo),
            Indicador(label: 'Cumplimiento pagos',  valor: '99.8%',
                      color: Colors.teal, subtitulo: 'Últimos 30 días'),
          ],
        ),
      ),
    ),// Paso 5 — ya tiene su propio Scaffold
    _ => Scaffold(body: Center(child: Text('Paso $paso: crea el widget primero'))),
  },
));


class Saludo extends StatelessWidget {
  const Saludo({super.key});
  @override
  Widget build(BuildContext context) =>
      const Text('Sistema de Nómina', style: TextStyle(fontSize: 32));
}
