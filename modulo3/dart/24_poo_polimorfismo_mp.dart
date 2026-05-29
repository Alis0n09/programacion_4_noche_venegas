abstract class BeneficioLaboral {
  String get nombre;
  double calcular();
}

class Decimo extends BeneficioLaboral {
  final double sueldo;
  Decimo(this.sueldo);
  @override String get nombre => 'Décimo';
  @override double calcular() => sueldo / 12;
}

class Bono extends BeneficioLaboral {
  final double sueldo;
  Bono(this.sueldo);
  @override String get nombre => 'Bono';
  @override double calcular() => sueldo * 0.1;
}

class HorasExtras extends BeneficioLaboral {
  final int horas;
  HorasExtras(this.horas);
  @override String get nombre => 'Horas Extras';
  @override double calcular() => horas * 4.50;
}

void imprimirBeneficio(BeneficioLaboral b) {
  print('${b.nombre}: \$${b.calcular().toStringAsFixed(2)}');
}

void main() {
  final beneficios = <BeneficioLaboral>[
    Decimo(1200.0),
    Bono(1200.0),
    HorasExtras(10),
  ];

  for (final b in beneficios) {
    imprimirBeneficio(b);
  }

  final mayor = beneficios.reduce((a, b) => a.calcular() > b.calcular() ? a : b);
  print('\nBeneficio más alto: ${mayor.nombre}');
}
