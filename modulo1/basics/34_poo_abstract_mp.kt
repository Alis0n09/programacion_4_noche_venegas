abstract class Beneficio(val nombre: String) {
    abstract val valor: Double
    abstract val descripcion: String
    abstract fun calcular(): Double

    fun comparar(otro: Beneficio): String = when {
        valor > otro.valor -> "$nombre es mayor que ${otro.nombre}"
        valor < otro.valor -> "$nombre es menor que ${otro.nombre}"
        else -> "$nombre y ${otro.nombre} son iguales"
    }

    override fun toString() = "${descripcion()} | Valor: \$${"%.2f".format(valor)}"
}

class DecimoTercero(val sueldo: Double) : Beneficio("Décimo Tercero") {
    override val valor: Double get() = sueldo / 12
    override val descripcion: String get() = "Décimo tercer sueldo"
    override fun calcular() = sueldo / 12
}

class FondosReserva(val sueldo: Double, val meses: Int) : Beneficio("Fondos de Reserva") {
    override val valor: Double get() = (sueldo / 12) * meses
    override val descripcion: String get() = "Fondos de reserva por $meses meses"
    override fun calcular() = (sueldo / 12) * meses
}

class Vacaciones(val sueldo: Double, val dias: Int) : Beneficio("Vacaciones") {
    override val valor: Double get() = (sueldo / 30) * dias
    override val descripcion: String get() = "Vacaciones por $dias días"
    override fun calcular() = (sueldo / 30) * dias
}

fun main() {
    val beneficios: List<Beneficio> = listOf(
        DecimoTercero(1200.0),
        FondosReserva(1200.0, 12),
        Vacaciones(1200.0, 15)
    )

    beneficios.forEach { println(it) }

    val mayor = beneficios.maxByOrNull { it.valor }
    println("\nBeneficio más alto: ${mayor?.nombre}")

    println(beneficios[0].comparar(beneficios[1]))
}
