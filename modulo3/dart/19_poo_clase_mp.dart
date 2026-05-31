class Empleado {
  final String id;
  final String nombre;
  double sueldo;
  bool _activo = false;

  Empleado({
    required this.id,
    required this.nombre,
    required this.sueldo,
  });

  bool get activo => _activo;
  String get estado => _activo ? 'activo' : 'inactivo';

  set estadoActivo(bool valor) {
    _activo = valor;
    print('$nombre: ${valor ? "contratado" : "despedido"}');
  }

  void contratar() {
    _activo = true;
    print('$nombre contratado con sueldo de \$$sueldo');
  }

  void despedir() {
    _activo = false;
    print('$nombre despedido');
  }

  String resumen() => 'ID: $id | $nombre | Sueldo: \$$sueldo | $estado';

  @override
  String toString() => 'Empleado($nombre, \$$sueldo, $estado)';
}

void main() {
  final emp = Empleado(
    id: 'EMP-001',
    nombre: 'Gabriela Calderon',
    sueldo: 1200.0,
  );

  emp.contratar();
  print(emp.estado);
  print(emp.resumen());
  print(emp);

  emp.estadoActivo = false;
  print(emp.activo);
}
