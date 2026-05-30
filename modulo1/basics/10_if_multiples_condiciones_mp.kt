fun main() {
    println("--- Clasificacion Salarial ---")
    println("Ingrese sueldo mensual del empleado:")
    val sueldo = readLine()?.toDoubleOrNull() ?: 0.0
    val clasificacion = if (sueldo < 460.0) {
        "Bajo el basico unificado"
    } else if (sueldo <= 600.0) {
        "Nivel inicial"
    } else if (sueldo <= 1000.0) {
        "Nivel medio"
    } else if (sueldo <= 2000.0) {
        "Nivel alto"
    } else {
        "Nivel ejecutivo"
    }
    println("Clasificacion: $clasificacion")
}
