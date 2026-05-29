void main() {
  int empleados = 0;
  int presupuesto = 5000;

  while (presupuesto > 0) {
    final pago = presupuesto > 1200 ? 1200 : presupuesto;
    empleados++;
    presupuesto -= pago;
    print('Empleado #$empleados: \$$pago (restante: \$$presupuesto)');
  }

  int intentos = 0;
  bool pagoRealizado = false;

  do {
    intentos++;
    print('Intento de pago #$intentos...');
    if (intentos == 3) pagoRealizado = true;
  } while (!pagoRealizado && intentos < 5);

  print(pagoRealizado
      ? 'Pago realizado tras $intentos intentos'
      : 'No se pudo realizar el pago');
}
