class Contrato(val sueldoBase: Double, val horasSemanales: Int) {
    val salarioMensual: Double get() = sueldoBase
    val salarioAnual: Double get() = sueldoBase * 12 + sueldoBase + sueldoBase

    constructor(sueldoBase: Double) : this(sueldoBase, 40)
    constructor(sueldoBase: Int, horas: Int) : this(sueldoBase.toDouble(), horas)

    override fun toString() = "Contrato(\$${sueldoBase}x${horasSemanales}h) | Anual=\$${salarioAnual}"
}

fun main() {
    val c1 = Contrato(800.0, 40)
    val c2 = Contrato(600.0)
    val c3 = Contrato(1000, 30)

    println(c1)
    println(c2)
    println(c3)
}
