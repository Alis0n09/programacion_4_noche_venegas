import 'dart:io';

void main() {
  double totalSueldos = 0;
  int totalEmpleados = 0;
  int totalDeptos = 0;
  int cantidad = 0;
  int empleados = -1;

  while (empleados != 0) {
    print('Ingrese la cantidad de empleados del departamento:');
    empleados = int.parse(stdin.readLineSync()!);

    if (empleados <= 0) {
      break;
    }

    print('Ingrese el total de sueldos del departamento:');
    double sueldos = double.parse(stdin.readLineSync()!);

    print('Ingrese el presupuesto anual:');
    double presupuesto = double.parse(stdin.readLineSync()!);

    double sueldoPromedio = sueldos / empleados;

    if (sueldoPromedio < 600) {
      print('Sueldos bajos');
    } else if (sueldoPromedio >= 600 && sueldoPromedio <= 1200) {
      print('Sueldos normales');
    } else {
      print('Sueldos altos');
    }

    totalSueldos += sueldos;
    totalEmpleados += empleados;
    totalDeptos += empleados;
    cantidad++;
  }

  print('Total de sueldos: \$$totalSueldos');
  print('Total de empleados: $totalEmpleados');
  print('Cantidad de departamentos: $cantidad');
}
