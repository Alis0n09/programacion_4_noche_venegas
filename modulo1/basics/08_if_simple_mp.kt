fun main() {
    println("=== Control de Impuesto a la Renta ===")
    println("Ingrese sueldo mensual del empleado:")

    val sueldo = readLine()?.toDoubleOrNull() ?: 460.0
    if (sueldo > 1172.00) {
        println("Empleado debe pagar Impuesto a la Renta")
    }
    if (sueldo >= 2000.00) {
        println("Aplica retención de fuente del 2%")
    }

    println("Sueldo registrado: \$$sueldo")
}
