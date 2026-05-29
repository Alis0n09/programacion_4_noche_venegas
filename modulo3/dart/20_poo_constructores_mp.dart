class Contrato {
  final String empleado;
  final double sueldo;
  final int horas;
  final bool esTiempoCompleto;

  Contrato({
    required this.empleado,
    required this.sueldo,
    required this.horas,
    this.esTiempoCompleto = true,
  });

  Contrato.medioTiempo({required this.empleado, required this.sueldo})
      : horas = 20,
        esTiempoCompleto = false;

  Contrato.completo({required this.empleado, required this.sueldo})
      : horas = 40,
        esTiempoCompleto = true;

  factory Contrato.desdeSalario(String empleado, double salarioMensual) {
    return Contrato(
      empleado: empleado,
      sueldo: salarioMensual,
      horas: 40,
    );
  }

  @override
  String toString() =>
      '$empleado - \$$sueldo (${esTiempoCompleto ? "TC" : "MT"} - ${horas}h)';
}

void main() {
  final c1 = Contrato(empleado: 'Ana García', sueldo: 1200.0, horas: 40);
  final c2 = Contrato.medioTiempo(empleado: 'Luis Vera', sueldo: 500.0);
  final c3 = Contrato.completo(empleado: 'María Ruiz', sueldo: 1500.0);
  final c4 = Contrato.desdeSalario('Pedro Salas', 800.0);

  print(c1);
  print(c2);
  print(c3);
  print(c4);
}
