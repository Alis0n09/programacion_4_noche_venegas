import 'dart:io';

void main() {
  // Forma básica
  print('Ingrese un numero para verificar que es: ');
  int numero = int.parse(stdin.readLineSync()!);

  if (numero > 0) {
    print('El numero es: Positivo');
  } else if (numero < 0) {
    print('El numero es: Negativo');
  } else {
    print('El numero es: Cero');
  }

}