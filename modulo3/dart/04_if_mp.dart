void main() {
  double sueldo = 1200.0;

  if (sueldo > 1172.0) {
    print('Debe pagar Impuesto a la Renta');
  } else if (sueldo > 460.0) {
    print('No paga impuesto a la renta');
  } else {
    print('Salario básico unificado');
  }

  String estado = sueldo > 1172.0 ? 'Con impuesto' : 'Sin impuesto';
  print(estado);

  String? bono;
  String display = bono != null ? bono.toUpperCase() : 'Sin bono';

  String display2 = bono?.toUpperCase() ?? 'Sin bono';
  print(display2);
}
