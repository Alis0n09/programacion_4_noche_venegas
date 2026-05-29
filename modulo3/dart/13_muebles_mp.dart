import 'dart:io';

void main() {
  int empleados = -1;
  int total = 0;
  int trabajadores = 0;
  double promedio = 0;

  while (empleados != 0) {
    print('Ingrese el total de empleados (0 para salir):');
    empleados = int.parse(stdin.readLineSync()!);

    if (empleados > 0) {
      trabajadores++;
      total = total + empleados;
    }

    if (empleados < 5) {
      print('Departamento pequeño');
    } else if (empleados <= 15) {
      print('Departamento mediano');
    } else {
      print('Departamento grande');
    }

    if (trabajadores > 0) {
      promedio = total / trabajadores;
    }
  }
  print('Total de empleados registrados: $total');
  print('Total de departamentos: $trabajadores');
  print('Promedio de empleados por depto: $promedio');
}
