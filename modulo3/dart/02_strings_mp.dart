void main() {
  final nombre = 'Ana';
  final sueldo = 1200.0;

  print('Empleado: $nombre');
  print('${nombre.toUpperCase()} tiene un sueldo de \$${sueldo}');

  final ficha = '''
Nombre: $nombre
Sueldo: \$$sueldo
Aporta IESS: ${sueldo >= 460 ? 'Sí' : 'No'}
  ''';
  print(ficha);

  final ruta = r'C:\Nomina\Reportes';
  print(ruta);

  final saludo = 'Bienvenido, ' + nombre + '!';

  print('nomina'.toUpperCase());
  print('  Ecuador  '.trim());
  print('Ecuador'.contains('cua'));
  print('nomina'.replaceAll('n', 'N'));
  print('a,b,c'.split(','));
  print('Nomina'.substring(0, 4));
  print('Nomina'.startsWith('Nom'));
  print('123'.padLeft(10, '0'));
}
