void main() {
  String tipoContrato = 'FIJO';

  switch (tipoContrato) {
    case 'FIJO':
      print('Contrato fijo - 1 año renovable');
    case 'INDEFINIDO':
      print('Contrato indefinido - estable');
    case 'TEMPORAL':
      print('Contrato temporal - hasta 6 meses');
    case 'PRACTICAS':
      print('Contrato de prácticas');
    default:
      print('Tipo de contrato desconocido');
  }

  String codigoDepto = 'SIS';

  String depto = switch (codigoDepto) {
    'SIS' => 'Sistemas',
    'CONT' => 'Contabilidad',
    'RRHH' => 'Recursos Humanos',
    'VENT' => 'Ventas',
    'PROD' => 'Producción',
    _ => 'Departamento desconocido',
  };

  print(depto);

  int nivelSalarial = 3;

  String categoria = switch (nivelSalarial) {
    1 || 2 => 'Salario básico',
    3 || 4 => 'Salario medio',
    5 || 6 => 'Salario alto',
    _ => 'No clasificado',
  };

  print(categoria);

  double sueldo = 1500.0;

  String resultado = switch (sueldo) {
    double s when s >= 2000 => 'Nivel ejecutivo',
    double s when s >= 1000 => 'Nivel medio-alto',
    double s when s >= 600 => 'Nivel medio',
    double s when s >= 460 => 'Nivel básico',
    _ => 'Por debajo del SBU',
  };

  print(resultado);
}
