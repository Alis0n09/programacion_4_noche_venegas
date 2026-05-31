import 'dart:io';

void main() {
  double total = 0;
  int cantidad = 0;
  double sueldo = -1;

  while (sueldo != 0) {
    print('Ingrese el sueldo del empleado:');
    sueldo = double.parse(stdin.readLineSync()!);

    if (sueldo <= 0) {
      break;
    }

    print('Ingrese las horas trabajadas:');
    int horas = int.parse(stdin.readLineSync()!);

    double valorHora = sueldo / 160;

    if (valorHora < 3) {
      print('Valor hora bajo');
    } else if (valorHora >= 3 && valorHora <= 6) {
      print('Valor hora normal');
    } else {
      print('Valor hora alto');
    }

    total += sueldo;
    cantidad++;
  }

  print('Total de sueldos: \$$total');
  print('Cantidad de empleados: $cantidad');

  if (cantidad > 0) {
    double promedio = total / cantidad;
    print('Promedio salarial: \$${promedio.toStringAsFixed(2)}');
  } else {
    print('Promedio salarial: \$0');
  }
}
