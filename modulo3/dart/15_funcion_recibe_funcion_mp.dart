List<double> filtrar(List<double> lista, bool Function(double) criterio) {
  return lista.where(criterio).toList();
}

bool esAlto(double s) => s > 1000;
bool esBajo(double s) => s < 600;

void main() {
  final datos = [800.0, 1200.0, 500.0, 1500.0, 460.0, 2000.0];

  print(filtrar(datos, esAlto));
  print(filtrar(datos, esBajo));

  print(filtrar(datos, (s) => s > 1000 && s < 2000));
}
