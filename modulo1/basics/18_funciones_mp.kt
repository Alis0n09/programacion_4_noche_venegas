fun main() {
    mostrarBienvenida()
    mostrarEmpleado("Carlos")
    val sb = 800.0
    val he = 15
    println("Sueldo bruto de \$sb + $he h extras = \$${calcularSueldoBruto(sb, he)}")
    println("Descuento IESS: \$${calcularDescuentoIESS(sb)}")
    operacionNomina()
    println("Sueldo neto: \$${calcularNeto(sb, he)}")
}

fun mostrarBienvenida() {
    println("--- SISTEMA DE NOMINA ECUADOR ---")
}

fun mostrarEmpleado(nombre: String) {
    println("Empleado: $nombre")
}

fun calcularSueldoBruto(sueldo: Double, horasExtras: Int): Double {
    return sueldo + (horasExtras * 4.50)
}

fun calcularDescuentoIESS(sueldo: Double) = sueldo * 0.0945

fun operacionNomina() {
    fun cuadrado(x: Int) = x * x
    println("Cuadrado de descuentos: ${cuadrado(10)}%")
}

val calcularNeto = { sueldo: Double, horas: Int -> sueldo + (horas * 4.50) - (sueldo * 0.0945) }
