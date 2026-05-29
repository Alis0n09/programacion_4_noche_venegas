fun main() {
    println("=== Cálculo de Promedio Salarial ===")
    println("Cuantos empleados va a registrar?")
    val cantidad = readLine()?.toIntOrNull() ?: 3
    var totalSueldos = 0
    repeat(cantidad) { i ->
        println("Sueldo del empleado ${i + 1}:")
        val sueldo = readLine()?.toDoubleOrNull() ?: 0.0
        totalSueldos += sueldo.toInt()
    }
    val promedio = totalSueldos / cantidad
    println("Promedio salarial: \$$promedio")
    println("Clasificación: ${
        when {
            promedio < 500 -> "Salario bajo"
            promedio <= 1000 -> "Salario medio"
            else -> "Salario alto"
        }
    }")
}
