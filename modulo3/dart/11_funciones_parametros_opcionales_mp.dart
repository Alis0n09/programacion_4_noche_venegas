String calcularSueldoNeto(double sueldo, int horasExtras, [double? bono]) {
  double total = sueldo + (horasExtras * 4.50);
  if (bono != null) {
    total += bono;
  }
  total -= sueldo * 0.0945;
  return '\$${total.toStringAsFixed(2)}';
}

void main() {
  print(calcularSueldoNeto(800.0, 10));
  print(calcularSueldoNeto(800.0, 10, 100.0));
}
