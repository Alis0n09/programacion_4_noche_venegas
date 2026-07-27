import 'dart:async';
import 'package:flutter/material.dart';

// Antes: Reloj (cronómetro genérico).
// Ahora: mismo mecanismo (Timer + ciclo de vida) pero aplicado a un
// control de asistencia: tiempo trabajado en el turno actual.
class Reloj extends StatefulWidget {
  const Reloj({super.key});

  @override
  State<Reloj> createState() => _RelojState();
}

class _RelojState extends State<Reloj> {
  late Timer _timer; // late — se asigna en initState, antes no existe
  int _segundos = 0;
  bool _pausado = false; // true = en receso / almuerzo
  int _marcaciones = 0;

  @override
  void initState() {
    super.initState(); // ← siempre primero
    _iniciarTimer();
  }

  void _iniciarTimer() {
    _timer = Timer.periodic(const Duration(milliseconds: 10), (_) {
      if (!mounted) return; // ← protege setState en callbacks
      setState(() => _segundos++);
    });
  }

  void _togglePausa() {
    setState(() {
      _pausado = !_pausado;
      if (_pausado) {
        _timer.cancel(); // pausa: cancela el timer actual (empleado sale a receso)
      } else {
        _iniciarTimer(); // reanuda: crea un timer nuevo (regresa del receso)
      }
    });
  }

  void _registrarMarcacion() {
    setState(() {
      _marcaciones = _marcaciones++;
    });
  }

  @override
  void dispose() {
    _timer.cancel(); // ← SIEMPRE liberar en dispose
    super.dispose(); // ← siempre al final
  }

  String get _formato {
    final h = _segundos ~/ 3600;
    final m = (_segundos % 3600) ~/ 60;
    final s = _segundos % 60;
    return '$h:${m.toString().padLeft(2, '0')}:${s.toString().padLeft(2, '0')}';
  }

  // Color cambia según el tiempo trabajado en el turno
  Color get _colorTiempo {
    if (_segundos > 120) return const Color.fromARGB(255, 0, 38, 255);
    if (_segundos > 60) return const Color.fromARGB(255, 158, 54, 244);
    if (_segundos > 30) return const Color.fromRGBO(255, 0, 242, 1);
    return Colors.green;
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          _formato,
          style: TextStyle(
            fontSize: 40,
            fontFamily: 'monospace',
            fontWeight: FontWeight.bold,
            color: _colorTiempo, // cambia automáticamente con el tiempo
          ),
        ),
        const SizedBox(height: 16),
        Row(
          mainAxisSize: MainAxisSize.min,
          children: [
            FilledButton.icon(
              onPressed: _togglePausa,
              icon: Icon(_pausado ? Icons.play_arrow : Icons.pause),
              label: Text(_pausado ? 'Reanudar turno' : 'Ir a receso'),
            ),
            const SizedBox(width: 8),
            TextButton(
              onPressed: () => setState(() {
                _timer.cancel();
                _segundos = 0;
                _pausado = false;
                _iniciarTimer();
              }),
              child: const Text('Reiniciar turno'),
            ),
          ],
        ),
        const SizedBox(height: 8),
        Text(
          _pausado ? 'En receso' : 'Trabajando',
          style: TextStyle(fontSize: 12, color: Colors.grey.shade600),
        ),

        const SizedBox(height: 8),
        TextButton(
          onPressed: () => setState(() {
            _marcaciones += 3;
          }),
          child: const Text('Registrar marcación con SetState'),
        ),

        const SizedBox(height: 8),
        TextButton(
          onPressed: _registrarMarcacion,
          child: const Text('Registrar marcación con Función'),
        ),
        Text(
          'Marcaciones: $_marcaciones',
          style: TextStyle(fontSize: 20, color: Colors.blueAccent.shade700),
        ),
      ],
    );
  }
}
