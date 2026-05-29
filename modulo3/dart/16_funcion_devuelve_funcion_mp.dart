double Function(double) crearMultiplicador(double factor) {
  return (double n) => n * factor;
}

void main() {
  final calcularIESS = crearMultiplicador(0.0945);
  final calcularIR = crearMultiplicador(0.05);
  final calcularDecimo = crearMultiplicador(1 / 12);

  print(calcularIESS(800.0));
  print(calcularIR(2000.0));
  print(calcularDecimo(1200.0));

  bool Function(double) crearValidadorSueldo(double min, double max) {
    return (sueldo) => sueldo >= min && sueldo <= max;
  }

  final esBasico = crearValidadorSueldo(460, 600);
  final esPremium = crearValidadorSueldo(1500, double.infinity);

  print(esBasico(500.0));
  print(esPremium(2000.0));
  print(esPremium(800.0));
}
