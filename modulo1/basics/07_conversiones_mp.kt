fun main() {
    println("--- Conversiones en Nomina ---")

    val sueldoEntero: Int = 460
    val sueldoDecimal: Double = sueldoEntero.toDouble()
    val sueldoLong: Long = sueldoEntero.toLong()
    val sueldoString: String = sueldoEntero.toString()

    println("to Double: \$$sueldoDecimal")
    println("to Long: $sueldoLong")
    println("to String: \$$sueldoString")

    println("String a Numerico")
    val horas = "160".toInt()
    val valorHora = "4.50".toDouble()

    val invalido = "abc".toIntOrNull()
    println(invalido)
}
