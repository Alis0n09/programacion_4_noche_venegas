// lib/concepto_nomina_mp.dart
class ConceptoNomina {
  final int     id;
  final String  nombre;
  final double  monto;      // antes 'precio'
  final bool    activo;
  final String? tipo;       // antes 'categoria' — ej. Ingreso, Egreso, Aporte

  const ConceptoNomina({
    required this.id,
    required this.nombre,
    required this.monto,
    required this.activo,
    this.tipo,
  });
}
