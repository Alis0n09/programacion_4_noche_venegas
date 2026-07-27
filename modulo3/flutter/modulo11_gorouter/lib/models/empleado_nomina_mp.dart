class EmpleadoNomina {
  final String id;
  final String nombre;
  final String codigoNomina; // antes 'ip'
  final int    numeroEmpleado; // antes 'puerto'
  final bool   afiliadoIess;   // antes 'ssl'

  const EmpleadoNomina({
    required this.id,
    required this.nombre,
    required this.codigoNomina,
    required this.numeroEmpleado,
    required this.afiliadoIess,
  });
}

// Lista simulada — en una app real vendría de un provider
const empleadosSimulados = [
  EmpleadoNomina(id: '1', nombre: 'Gabriela Calderón', codigoNomina: '012.003.001.001', numeroEmpleado: 22,   afiliadoIess: true),
  EmpleadoNomina(id: '2', nombre: 'Jorge Vera',        codigoNomina: '012.003.002.002', numeroEmpleado: 22,   afiliadoIess: true),
  EmpleadoNomina(id: '3', nombre: 'Mateo Alba',        codigoNomina: '012.004.001.003', numeroEmpleado: 2222, afiliadoIess: false),
];
