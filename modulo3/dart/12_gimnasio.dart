import 'dart:io';

void main() {
  int minutos= 0;
  int cantidad = 0;
  int suma = 0 ;
  double promedio = 0;

  while (true) {
    print('Ingrese la cantidad de minutos que entreno en un dia (0 para salir):');
    minutos = int.parse(stdin.readLineSync()!);
    if (minutos == 0){
      break;
    }

    suma += minutos;
    cantidad ++;

    if (minutos < 30) {
      print('Entranamiento insuficiente');
    } else if (minutos <= 90) {
      print('Entranamiento adecuado');
    } else {
      print('Entranamiento intenso');
    } 
  }

  if (cantidad > 0) {
    promedio = suma / cantidad ;
  }

  print('La suma total de minutos entrenados es: $suma');
  print('La cantidad de clientes registrados es: $cantidad');
  print('El promedio de minutos es: $promedio');
}