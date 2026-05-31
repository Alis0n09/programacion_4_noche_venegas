abstract class Beneficio {
  String get nombre;
  double calcular();     // cada beneficio lo implementa a su manera

  void describir() {
    print('$nombre — valor: \$${calcular().toStringAsFixed(2)}');
  }
}

class DecimoTercero extends Beneficio {
  final double sueldo;
  DecimoTercero(this.sueldo);

  @override String get nombre => 'Décimo Tercero';
  @override double calcular() => sueldo / 12;
}

class FondosReserva extends Beneficio {
  final double sueldo;
  final int meses;
  FondosReserva(this.sueldo, this.meses);

  @override String get nombre => 'Fondos de Reserva ($meses meses)';
  @override double calcular() => (sueldo / 12) * meses;
}

void main() {
  final beneficios = <Beneficio>[DecimoTercero(1200.0), FondosReserva(1200.0, 12)];
  for (final b in beneficios) {
    b.describir();
  }
}
