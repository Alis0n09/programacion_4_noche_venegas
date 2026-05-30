class EmpleadoBase {
  final String nombre;
  final double sueldoBase;

  EmpleadoBase(this.nombre, this.sueldoBase);

  String calcularPago() => '...';

  void presentarse() {
    print('$nombre - Sueldo base: \$$sueldoBase - Pago: ${calcularPago()}');
  }
}

class TiempoCompleto extends EmpleadoBase {
  TiempoCompleto(super.nombre, super.sueldoBase);

  @override
  String calcularPago() => '\$${sueldoBase + 200} (+ bono)';

  void asignarBono() => print('$nombre recibe bono de \$${sueldoBase * 0.1}');
}

class MedioTiempo extends EmpleadoBase {
  MedioTiempo(super.nombre, super.sueldoBase);

  @override
  String calcularPago() => '\$${sueldoBase * 0.5} (medio tiempo)';
}

void main() {
  final tc = TiempoCompleto('Gabriela Calderon', 1200.0);
  final mt = MedioTiempo('Ines Vera', 500.0);

  tc.presentarse();
  mt.presentarse();

  tc.asignarBono();
}
