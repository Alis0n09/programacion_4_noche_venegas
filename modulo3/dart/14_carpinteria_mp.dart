import 'dart:io';

void main() {
  double sueldo = -1;
  double total = 0;
  int empleados = 0;
  double promedio = 0;

  while (sueldo != 0) {
    print('Ingrese el sueldo del empleado (0 para salir):');
    sueldo = double.parse(stdin.readLineSync()!);

    if (sueldo > 0) {
      empleados++;
      total = total + sueldo;
    }

    if (sueldo < 460) {
      print('Sueldo bajo');
    } else if (sueldo <= 1000) {
      print('Sueldo normal');
    } else {
      print('Sueldo alto');
    }

    if (empleados > 0) {
      promedio = total / empleados;
    }
  }
  print('Total sueldos: \$$total');
  print('Total empleados: $empleados');
  print('Promedio por empleado: \$${promedio.toStringAsFixed(2)}');
}
