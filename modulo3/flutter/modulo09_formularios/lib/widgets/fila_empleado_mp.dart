// lib/widgets/fila_empleado_mp.dart
import 'package:flutter/material.dart';
import '../models/empleado_nomina_mp.dart';

class FilaEmpleado extends StatelessWidget {
  final EmpleadoNomina empleado;
  final VoidCallback   onPrioritario;
  final VoidCallback   onEliminar;

  const FilaEmpleado({
    super.key,
    required this.empleado,
    required this.onPrioritario,
    required this.onEliminar,
  });

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return ListTile(
      // leading — icono con color según afiliación al IESS
      leading: CircleAvatar(
        backgroundColor: empleado.afiliadoIess
            ? cs.primaryContainer
            : cs.surfaceContainerHighest,
        child: Icon(
          Icons.badge,
          color: empleado.afiliadoIess ? cs.onPrimaryContainer : cs.onSurfaceVariant,
        ),
      ),
      title: Text(
        empleado.nombre,
        style: const TextStyle(fontWeight: FontWeight.w600),
      ),
      subtitle: Text(
        '${empleado.cargo} · ${empleado.codigoNomina} · #${empleado.numeroEmpleado}',
        style: TextStyle(fontSize: 12, color: cs.onSurfaceVariant),
      ),
      // trailing — dos acciones compactas
      trailing: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          IconButton(
            icon: Icon(
              empleado.prioritario ? Icons.star : Icons.star_border,
              color: empleado.prioritario ? Colors.amber : cs.outline,
            ),
            onPressed:     onPrioritario,
            visualDensity: VisualDensity.compact,
            tooltip:       empleado.prioritario ? 'Quitar prioridad' : 'Marcar como prioritario',
          ),
          IconButton(
            icon:          Icon(Icons.delete_outline, color: cs.error),
            onPressed:     onEliminar,
            visualDensity: VisualDensity.compact,
            tooltip:       'Eliminar',
          ),
        ],
      ),
      contentPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 4),
    );
  }
}
