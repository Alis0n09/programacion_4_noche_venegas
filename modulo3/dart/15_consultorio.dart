import 'dart:io';

void main() {
  int total = 0;
  int cantidad = 0;
  double horas = -1;

  while (horas != 0) {
    print('Ingrese las horas trabajadas por doctor:');
    horas = double.parse(stdin.readLineSync()!);

    if (horas <= 0) {
      break;
    }

    print('Ingrese la cantidad de pacientes atendidos:');
    int pacientes = int.parse(stdin.readLineSync()!);

    
    double pacientesHora = pacientes / horas;

    if (pacientesHora < 3) {
      print('Atención lenta');
    } else if (pacientesHora >= 3 && pacientesHora <= 6) {
      print('Atención normal');
    } else {
      print('Atención rápida');
    }

    total += pacientes;
    cantidad++;
  }

  print('Total de pacientes atendidos: $total');
  print('Cantidad de doctores registrados: $cantidad');

  if (cantidad > 0) {
    double promedio = total / cantidad;
    print('Promedio de pacientes por doctor: $promedio');
  } else {
    print('Promedio de pacientes por doctor es 0');
  }
}