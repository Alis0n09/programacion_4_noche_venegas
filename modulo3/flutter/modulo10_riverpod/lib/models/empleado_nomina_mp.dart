// lib/models/empleado_nomina_mp.dart
class EmpleadoNomina {
  final String id;
  final String nombre;
  final String codigoNomina; // antes 'ip'
  final int    numeroEmpleado; // antes 'puerto'
  final bool   afiliadoIess;   // antes 'ssl'
  bool         prioritario;    // antes 'favorito'

  EmpleadoNomina({
    required this.id,
    required this.nombre,
    required this.codigoNomina,
    required this.numeroEmpleado,
    required this.afiliadoIess,
    this.prioritario = false,
  });
}
