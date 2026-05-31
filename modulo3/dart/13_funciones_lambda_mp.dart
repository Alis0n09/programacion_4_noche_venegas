void main() {
  final calcularSbu = (int horas) => horas * 4.50;
  print(calcularSbu(160));

  final calcularDescuento = (double sueldo, double pct) {
    final descuento = sueldo * (pct / 100);
    return sueldo - descuento;
  };
  print(calcularDescuento(800.0, 9.45));

  final sueldos = [800.0, 1200.0, 500.0, 1500.0];
  sueldos.sort((a, b) => b.compareTo(a));
  print(sueldos);
}
