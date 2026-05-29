fun main() {
    println("=== Registro de Empleado ===")
    println("Ingrese nombre del empleado:")

    val nombre = readLine() ?: "sin nombre"
    println("Empleado: $nombre")

    println("Ingrese sueldo base:")
    val sueldo = readLine()?.toDoubleOrNull() ?: 460.0
    println("Sueldo base: \$$sueldo")

    val doble = sueldo * 2
    println("El doble del sueldo es: \$$doble")
}
