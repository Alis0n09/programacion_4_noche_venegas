void main() {
  int sueldoEntero = 460;
  double sueldoDecimal = sueldoEntero.toDouble();
  String sueldoTexto = sueldoEntero.toString();

  int horas = int.parse('160');
  double valorHora = double.parse('4.50');

  int? num3 = int.tryParse('abc');
  double? num4 = double.tryParse('99');

  Object valor = '800.00';
  if (valor is String) {
    print(valor.length);
  }

  Object obj = '1200.00';
  String str = obj as String;

  String? nullable = null;
  int longitud = nullable?.length ?? 0;
  print(longitud);

  print(double.infinity);
  print(double.nan);
  print(double.maxFinite);
}
