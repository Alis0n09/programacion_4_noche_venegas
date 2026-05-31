Future<String> obtenerTotalNomina() async {
  await Future.delayed(Duration(milliseconds: 200));
  return '\$8,500.00';
}

void main() async {
  print('Calculando nómina...');
  final total = await obtenerTotalNomina();
  print('Total de nómina: $total');
  print('Cálculo completado');
}
