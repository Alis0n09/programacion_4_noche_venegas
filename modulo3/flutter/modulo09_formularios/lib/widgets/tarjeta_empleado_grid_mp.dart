// lib/widgets/tarjeta_empleado_grid_mp.dart
import 'package:flutter/material.dart';
import '../models/empleado_nomina_mp.dart';

class TarjetaEmpleadoGrid extends StatelessWidget {
  final EmpleadoNomina empleado;
  final VoidCallback   onPrioritario;
  final VoidCallback   onEliminar;

  const TarjetaEmpleadoGrid({
    super.key,
    required this.empleado,
    required this.onPrioritario,
    required this.onEliminar,
  });

  @override
  Widget build(BuildContext context) {
    final cs   = Theme.of(context).colorScheme;
    final text = Theme.of(context).textTheme;

    return Card(
      child: Padding(
        padding: const EdgeInsets.all(10),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Fila superior: icono + prioritario
            Row(children: [
              Icon(
                Icons.badge,
                color: empleado.afiliadoIess ? cs.primary : cs.outline,
                size: 18,
              ),
              const Spacer(),
              GestureDetector(
                onTap: onPrioritario,
                child: Icon(
                  empleado.prioritario ? Icons.star : Icons.star_border,
                  color: empleado.prioritario ? Colors.amber : cs.outline,
                  size: 18,
                ),
              ),
            ]),
            const SizedBox(height: 6),

            // Nombre y código de nómina
            Text(
              empleado.nombre,
              style: text.titleSmall?.copyWith(fontWeight: FontWeight.bold),
              maxLines: 1,
              overflow: TextOverflow.ellipsis,
            ),
            Text(
              empleado.codigoNomina,
              style: text.bodySmall?.copyWith(color: cs.onSurfaceVariant),
            ),

            const Spacer(),

            // Fila inferior: IESS + departamento + eliminar
            Row(children: [
              if (empleado.afiliadoIess)
                Padding(
                  padding: const EdgeInsets.only(right: 4),
                  child: Icon(Icons.verified_user, size: 12, color: cs.primary),
                ),
              Expanded(
                child: Text(
                  empleado.departamento,
                  style: text.labelSmall?.copyWith(color: cs.onSurfaceVariant),
                  overflow: TextOverflow.ellipsis,
                ),
              ),
              GestureDetector(
                onTap: onEliminar,
                child: Icon(Icons.delete_outline, size: 16, color: cs.error),
              ),
            ]),
          ],
        ),
      ),
    );
  }
}
