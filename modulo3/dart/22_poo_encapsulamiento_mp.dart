class CuentaEmpleado {
  final String nombre;
  double _sueldo;

  CuentaEmpleado(this.nombre, double sueldoInicial)
      : _sueldo = sueldoInicial;

  double get sueldo => _sueldo;

  void aumentar(double monto) {
    if (monto <= 0) throw ArgumentError('El aumento debe ser positivo');
    _sueldo += monto;
    print('Aumento de \$$monto. Nuevo sueldo: \$$_sueldo');
  }

  void descontar(double monto) {
    if (monto <= 0) throw ArgumentError('El descuento debe ser positivo');
    if (monto > _sueldo) throw StateError('Saldo insuficiente');
    _sueldo -= monto;
    print('Descuento de \$$monto. Nuevo sueldo: \$$_sueldo');
  }
}

void main() {
  final emp = CuentaEmpleado('Ana López', 800.0);

  emp.aumentar(200.0);
  emp.descontar(50.0);
  print(emp.sueldo);
}
