fun main() {
    println("--- Calculo de Descuentos ---")
    println("Sueldo del empleado:")
    val sueldo = readLine()?.toDoubleOrNull() ?: 0.0
    println("Tiene credito hipotecario? s/n")
    val tieneHipoteca = readLine()?.trim()?.lowercase() == "s"

    val nivelCredito = if (tieneHipoteca) {
        println("Nivel de credito (BAJO/MEDIO/ALTO):")
        readLine()?.trim()?.uppercase() ?: ""
    } else ""

    val descuento = when {
        !tieneHipoteca && sueldo < 600 -> 0.0
        !tieneHipoteca && sueldo >= 1000 -> sueldo * 0.05
        !tieneHipoteca -> sueldo * 0.02
        nivelCredito == "BAJO" -> sueldo * 0.10
        nivelCredito == "MEDIO" -> sueldo * 0.15
        nivelCredito == "ALTO" -> sueldo * 0.20
        else -> sueldo * 0.05
    }
    println("Descuento aplicado: \$${"%.2f".format(descuento)}")
}
