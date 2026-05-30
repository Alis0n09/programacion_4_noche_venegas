fun main() {
    println("--- Departamento del Empleado ---")
    println("Código de departamento? (1-6)")
    println("1 -> Contabilidad")
    println("2 -> Recursos Humanos")
    println("3 -> Sistemas")
    println("4 -> Ventas")
    println("5 -> Producción")
    println("6 -> Logística")
    val codigo = readLine()?.toIntOrNull() ?: 0
    val departamento = when (codigo) {
        1 -> "Contabilidad"
        2 -> "Recursos Humanos"
        3 -> "Sistemas"
        4 -> "Ventas"
        5 -> "Producción"
        6 -> "Logística"
        else -> "Departamento no registrado"
    }
    println("Departamento: $departamento")
}
