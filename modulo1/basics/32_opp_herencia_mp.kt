open class EmpleadoBase(val nombre: String, val sueldoBase: Double) {
    open fun calcularPago() = println("$nombre recibe \$$sueldoBase")
    open fun descripcion() = "Empleado: $nombre"

    fun registrar() = println("$nombre registrado en el sistema")
}

class TiempoCompleto(nombre: String, sueldoBase: Double, val bono: Double) : EmpleadoBase(nombre, sueldoBase) {
    override fun calcularPago() {
        super.calcularPago()
        println("(más bono de \$$bono)")
    }
    override fun descripcion() = "${super.descripcion()}, tiempo completo"
}

class MedioTiempo(nombre: String, sueldoBase: Double, val horasSemanales: Int) : EmpleadoBase(nombre, sueldoBase) {
    override fun descripcion() =
        "${super.descripcion()}, medio tiempo ($horasSemanales h/semana)"
}

fun main() {
    val emp1 = TiempoCompleto("Ana López", 1200.0, 200.0)
    emp1.calcularPago()

    val emp2 = MedioTiempo("Luis Vera", 500.0, 20)
    println(emp2.descripcion())

    emp1.registrar()
}
