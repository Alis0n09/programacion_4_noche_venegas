import 'dart:io';

void main() {
  double totalK = 0;
  int totalV = 5;


  for (int i = 1; i <= totalV; i++) {
    print('Ingrese los kilómetros del viaje $i:');
    double kilometrosViaje = double.parse(stdin.readLineSync()!);

   
    if (kilometrosViaje < 50) {
      print('Ruta corta');
    } else if (kilometrosViaje >= 50 && kilometrosViaje <= 150) {
      print('Ruta media');
    } else {
      print('Ruta larga');
    }

    totalK += kilometrosViaje;
  }

  double consumo = totalK / 12;
  double promedioK = totalK / totalV;

  print('Total de kilómetros recorridos: $totalK');
  print('Total de combustible aproximado: $consumo litros');
  print('Promedio de kilometros por viaje: $promedioK');
}