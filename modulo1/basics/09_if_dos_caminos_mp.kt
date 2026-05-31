fun main() {
    println("--- Afiliación IESS ---")
    println("Está afiliado al IESS? s/n")

    val afiliado = readLine()?.trim()?.lowercase() == "s"
    println("Sueldo mensual:")
    val sueldo = readLine()?.toDoubleOrNull() ?: 0.0
    if (afiliado) {
        val descuento = sueldo * 0.0945
        println("Aporte IESS 9.45%: \$$descuento")
        println("Sueldo neto: \$${sueldo - descuento}")
    } else {
        println("Sin afiliacion - Sueldo integro: \$$sueldo")
    }
}
