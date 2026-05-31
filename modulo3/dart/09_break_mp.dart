void main() {
  final sueldos = [1200, 800, -1, 1500, 950, -1, 2000];

  print('--- Procesando nómina con continue ---');
  for (final sueldo in sueldos) {
    if (sueldo < 0) {
      print('Sueldo invalido ignorado');
      continue;
    }
    print('Procesando sueldo de \$$sueldo');
  }

  print('\n--- Procesando nomina con break ---');
  for (final sueldo in sueldos) {
    if (sueldo < 0) {
      print('Error critico — deteniendo nomina');
      break;
    }
    print('Procesando sueldo de \$$sueldo');
  }
}
