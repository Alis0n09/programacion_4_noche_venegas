import 'dart:io';

void main() {
  int totalPasajeros = 0;
  int totalMinutos = 0;
  int totalVuelos = 0;
  int cantidadAgentes = 0;
  int vuelos = -1;

  while (vuelos != 0) {
    print('Ingrese la cantidad de vuelos atendidos:');
    vuelos = int.parse(stdin.readLineSync()!);

    if (vuelos <= 0) {
      break;
    }

    print('Ingrese la cantidad de pasajeros procesados:');
    int pasajeros = int.parse(stdin.readLineSync()!);

    print('Ingrese los minutos de retraso:');
    int retraso = int.parse(stdin.readLineSync()!);

  
    double pasajerosPorVuelo = pasajeros / vuelos;
    
   
    if (pasajerosPorVuelo < 50) {
      print('Baja eficiencia');
    } else if (pasajerosPorVuelo >= 50 && pasajerosPorVuelo <= 120) {
      print('Eficiencia normal');
    } else {
      print('Alta eficiencia');
    }

    
    totalPasajeros += pasajeros;
    totalMinutos += retraso;
    totalVuelos += vuelos;
    cantidadAgentes++;
  }

  print('Total de pasajeros procesados: $totalPasajeros');
  print('Total de minutos de retraso acumulados: $totalMinutos');
  print('Cantidad de agentes registrados: $cantidadAgentes');


  if (cantidadAgentes > 0) {
    double promedioPasajerosAgente = totalPasajeros / cantidadAgentes;
    print('Promedio de pasajeros: $promedioPasajerosAgente');
  } else {
    print('Promedio de pasajeros es 0');
  }

  if (totalVuelos > 0) {
    double promedioRetraso = totalMinutos / totalVuelos;
    print('Promedio de retraso por vuelo: $promedioRetraso');
  } else {
    print('Promedio de retraso por vuelo es 0');
  }
}