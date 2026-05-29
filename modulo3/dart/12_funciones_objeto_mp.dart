double calcularSueldoBruto(double s) => s * 1.0;
double calcularSueldoNeto(double s) => s - (s * 0.0945);

void main() {
  double Function(double) operacion;

  operacion = calcularSueldoBruto;
  print(operacion(800.0));

  operacion = calcularSueldoNeto;
  print(operacion(800.0));

  final transformaciones = <double Function(double)>[calcularSueldoBruto, calcularSueldoNeto];
  for (final fn in transformaciones) {
    print(fn(1200.0));
  }
}
