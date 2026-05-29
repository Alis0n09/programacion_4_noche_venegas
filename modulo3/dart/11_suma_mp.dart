import 'dart:io';

void main() {
  double sueldo = -1;
  double suma = 0;

  while (sueldo != 0) {
    print('Ingrese un sueldo (0 para salir):');
    sueldo = double.parse(stdin.readLineSync()!);

    if (sueldo != 0) {
      suma = suma + sueldo;
      print('Sueldo: \$$sueldo');
    }
  }

  print('La suma total de sueldos es: \$$suma');
  print('Programa finalizado.');
}
