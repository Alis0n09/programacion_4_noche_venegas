double calcularSueldoAnual(double sueldo, int meses) {
  if (meses <= 0) return 0;
  return sueldo * meses + calcularDecimos(sueldo, meses);
}

double calcularDecimos(double sueldo, int meses) {
  if (meses <= 0) return 0;
  return (sueldo / 12 * meses) * 2;
}

int contarEmpleadosPorDepto(Map<String, dynamic> deptos) {
  int total = 0;
  for (final entrada in deptos.entries) {
    if (entrada.value is Map) {
      total += contarEmpleadosPorDepto(entrada.value as Map<String, dynamic>);
    } else {
      total++;
    }
  }
  return total;
}

void main() {
  print(calcularSueldoAnual(1200.0, 12));

  final organigrama = {
    'Sistemas': {
      'Desarrollo': {'Ana': true, 'Luis': true},
      'Soporte': {'Carlos': true},
    },
    'Contabilidad': {'Maria': true, 'Pedro': true},
    'Gerencia': {'Sofia': true},
  };

  print('Total empleados: ${contarEmpleadosPorDepto(organigrama)}');
}
