import 'dart:io';

void main() {
  print('Ingrese nombre del empleado:');
  String? nombre = stdin.readLineSync();
  print('Empleado: $nombre');

  print('Ingrese sueldo base:');
  double sueldo = double.parse(stdin.readLineSync()!);
  print('Sueldo: \$$sueldo');

  print('Ingrese horas extras:');
  int horas = int.parse(stdin.readLineSync()!);
  print('Horas extras: $horas');
}
