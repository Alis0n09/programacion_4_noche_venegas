fun main() {
    println("=== CICLO for - Liquidación de Nómina ===")
    for (i in 1..5) {
        println("Procesando empleado #$i")
    }
    println("Subida salarial anual")
    for (i in 1 until 5) {
        println("Año $i: incremento del 3%")
    }
    println("Countdown fin de mes")
    for (i in 10 downTo 1) {
        println("Días restantes para cierre: $i")
    }
    println("Lista de empleados")
    val empleados = listOf("Ana", "Luis", "Juana", "Pedro", "Sofía")
    for (empleado in empleados) {
        println("Empleado: $empleado")
    }
    println("Índice y valor")
    for ((index, valor) in empleados.withIndex()) {
        println("$index: $valor")
    }
    println("Procesar hasta encontrar inactivo")
    for (i in 1..5) {
        if (i == 3) {
            println("Empleado #$i inactivo - deteniendo")
            break
        }
        println("Empleado #$i procesado")
    }
    println("Saltar inactivos")
    for (i in 1..5) {
        if (i == 3) {
            println("Empleado #$i inactivo - saltando")
            continue
        }
        println("Empleado #$i procesado")
    }
}
