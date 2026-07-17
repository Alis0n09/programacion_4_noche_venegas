// lib/models/empleado_nomina_mp.dart
class EmpleadoNomina {
  final String id;
  final String nombre;
  final String codigoNomina; // antes 'ip' — formato región.depto.sucursal.número
  final int    numeroEmpleado; // antes 'puerto' (1–65535)
  final String cargo;          // antes 'usuario'
  final String departamento;   // antes 'so' (sistema operativo)
  final bool   afiliadoIess;   // antes 'ssl'
  bool         prioritario;    // antes 'favorito' — mutable, sin recrear el objeto

  EmpleadoNomina({
    required this.id,
    required this.nombre,
    required this.codigoNomina,
    required this.numeroEmpleado,
    required this.cargo,
    required this.departamento,
    required this.afiliadoIess,
    this.prioritario = false,
  });
}
