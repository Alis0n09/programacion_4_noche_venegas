import 'dart:io';

void main() {
  double totalSueldos = 0;
  int totalEmpleados = 5;

  for (int i = 1; i <= totalEmpleados; i++) {
    print('Ingrese el sueldo del empleado $i:');
    double sueldo = double.parse(stdin.readLineSync()!);

    if (sueldo < 460) {
      print('Sueldo bajo');
    } else if (sueldo >= 460 && sueldo <= 1000) {
      print('Sueldo medio');
    } else {
      print('Sueldo alto');
    }

    totalSueldos += sueldo;
  }

  double promedio = totalSueldos / totalEmpleados;

  print('Total de sueldos: \$$totalSueldos');
  print('Promedio salarial: \$${promedio.toStringAsFixed(2)}');
}
