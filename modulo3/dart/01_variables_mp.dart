void main() {
  var nombre = 'Gabriela';           // String
  var sueldo = 1200.00;         // double
  var activo = true;            // bool

  String apellido = 'García';
  int    horas    = 160;
  double bono     = 50.00;
  bool   afiliado = true;

  final empresa = 'Corporación Ecuador S.A.';

  const sbu = 460.0;
  const iva = 0.12;

  final ahora = DateTime.now();

  print('$nombre $apellido - Sueldo: \$$sueldo - Empresa: $empresa');

  var contador = 0;
  contador = 1;

  final lista = [1200.0, 800.0, 1500.0];
  lista.add(950.0);

  const impuestos = [0.0945, 0.02, 0.05];

  String nombre2 = 'Jorge';
  String? apellido2 = null;
  apellido2 = 'Vera';

  String? ciudad = 'Quito';
  print(ciudad?.length);

  String resultado = ciudad ?? 'Sin ciudad';
  print(resultado);

  String ciudadSegura = ciudad!;

  if (apellido2 != null) {
    print(apellido2.length);
  }

  late String token;
  token = 'nomina-2024';
  print(token);
}
