import 'dart:io';

void main() {
  double totalSueldos = 0;
  int dias = 30;

  for (int i = 1; i <= dias; i++) {
    print('Ingrese las ventas del día $i:');
    double ventasDia = double.parse(stdin.readLineSync()!);
    totalSueldos += ventasDia;
  }

  double promedioDiario = totalSueldos / dias;

  print('Total de ventas del mes: \$$totalSueldos');
  print('Promedio diario: \$${promedioDiario.toStringAsFixed(2)}');

  if (promedioDiario < 500) {
    print('Rendimiento: Bajo');
  } else if (promedioDiario <= 1500) {
    print('Rendimiento: Normal');
  } else {
    print('Rendimiento: Alto');
  }
}
