import 'dart:io';

void main() {
  double sueldo = 0;
  int cantidad = 0;
  double suma = 0;
  double promedio = 0;

  while (true) {
    print('Ingrese el sueldo del empleado (0 para salir):');
    sueldo = double.parse(stdin.readLineSync()!);
    if (sueldo == 0) {
      break;
    }

    suma += sueldo;
    cantidad++;

    if (sueldo < 460) {
      print('Salario por debajo del SBU');
    } else if (sueldo <= 1000) {
      print('Salario medio');
    } else {
      print('Salario alto');
    }
  }

  if (cantidad > 0) {
    promedio = suma / cantidad;
  }

  print('La suma total de sueldos es: \$$suma');
  print('La cantidad de empleados registrados es: $cantidad');
  print('El promedio de sueldos es: \$${promedio.toStringAsFixed(2)}');
}
