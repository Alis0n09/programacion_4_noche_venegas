import 'dart:io';

void main () {
  print ('Ingrese un numero para ver la tabla :');
  int numero = int.parse(stdin.readLineSync()!);

  for (int i = 1; i <= 10; i++) {
    print('Tabla numero $i');

  print('$numero * $i = ${numero * i}');

  }

}