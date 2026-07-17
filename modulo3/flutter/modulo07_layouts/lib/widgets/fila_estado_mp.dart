import 'package:flutter/material.dart';

// Fila de estado de un empleado dentro de la nómina — demuestra
// Row + Expanded + Spacer: el nombre se expande y ocupa el espacio
// disponible, mientras el detalle y el punto de estado quedan fijos.
class FilaEstado extends StatelessWidget {
  final String nombre;
  final String detalle;
  final bool   activo;

  const FilaEstado({
    super.key,
    required this.nombre,
    required this.detalle,
    required this.activo,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
      child: Row(
        children: [
          // ── Punto de estado (activo / inactivo) ──────────────────
          Container(
            width:  10,
            height: 10,
            decoration: BoxDecoration(
              color: activo ? Colors.green : Colors.red,
              shape: BoxShape.circle,
            ),
          ),
          const SizedBox(width: 12),

          // ── Expanded: el nombre ocupa todo el espacio sobrante ───
          Expanded(
            child: Text(
              nombre,
              overflow: TextOverflow.ellipsis,
              style: const TextStyle(fontWeight: FontWeight.w600, fontSize: 15),
            ),
          ),

          // ── Spacer alternativo: separa nombre de detalle ─────────
          const SizedBox(width: 12),

          Text(
            detalle,
            style: TextStyle(fontSize: 12, color: Colors.grey.shade600),
          ),
        ],
      ),
    );
  }
}
