import 'dart:io';

void main() {
  print('Ingrese el sueldo base para calcular el neto:');
  double sueldo = double.parse(stdin.readLineSync()!);

  print('Tabla de descuentos para sueldo de \$$sueldo');
  for (int i = 1; i <= 10; i++) {
    double descuento = sueldo * 0.01 * i;
    double neto = sueldo - descuento;
    print('$i% descuento = \$${descuento.toStringAsFixed(2)} → Neto: \$${neto.toStringAsFixed(2)}');
  }
}
