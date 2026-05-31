void main() {
  final sueldos = [800.0, 1200.0, 500.0, 1500.0, 2000.0];

  final sueldosNetos = sueldos.map((s) => (s * 0.9055).toStringAsFixed(2));
  print(sueldosNetos.toList());

  final deptos = ['/sistemas', '/contabilidad', '/ventas'];
  final rutas = deptos.map((d) => 'https://nomina.ec$d');
  print(rutas.toList());

  final sueldosAltos = sueldos.where((s) => s > 1000);
  print(sueldosAltos.toList());

  final sueldosMedios = sueldos.where((s) => s >= 460 && s <= 1000);
  print(sueldosMedios.toList());
}
