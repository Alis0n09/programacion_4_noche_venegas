import 'dart:io';

void main() {
  print('Ingrese el sueldo del empleado:');
  double sueldo = double.parse(stdin.readLineSync()!);

  if (sueldo > 1172.0) {
    print('Aplica Impuesto a la Renta');
  } else if (sueldo > 0) {
    print('No aplica Impuesto a la Renta');
  } else {
    print('Sueldo inválido');
  }
}
