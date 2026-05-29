void mostrarBienvenida() {
  print('Sistema de Nómina Ecuador');
}

void mostrarEmpleado(String nombre) {
  print('Empleado: $nombre');
}

double obtenerSueldo() {
  return 800.0;
}

double sumarSueldos(double a, double b) {
  return a + b;
}

double calcularIESS(double sueldo) => sueldo * 0.0945;

void main() {
  mostrarBienvenida();
  mostrarEmpleado('Ana García');
  double sueldo = obtenerSueldo();
  print(sueldo);
  print('La suma es: \$${sumarSueldos(800, 200)}');
  print('El IESS es: \$${calcularIESS(800)}');
}
