void main() {
  for (int i = 1; i <= 5; i++) {
    print('Procesando empleado #$i');
  }

  for (int i = 0; i <= 100; i += 25) {
    print('Nómina procesada: $i%');
  }

  for (int i = 10; i >= 1; i--) {
    print('Días para cierre de nómina: $i');
  }
}
