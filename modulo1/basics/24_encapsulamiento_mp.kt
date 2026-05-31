open class EmpleadoNomina(nombre: String, sueldoInicial: Double) {

    val nombre: String = nombre

    private var sueldo: Double = sueldoInicial

    internal val codigoEmpleado: String =
        "EMP${(1000..9999).random()}"

    protected open fun calcularBono(): Double = sueldo * 0.05

    fun asignarAumento(monto: Double) {
        require(monto > 0) { "El aumento debe ser positivo" }
        sueldo += monto
        println("Aumento: \$${"%.2f".format(monto)} | Nuevo sueldo: ${consultarSueldo()}")
    }

    fun descontar(monto: Double): Boolean {
        require(monto > 0) { "El descuento debe ser positivo" }
        if (monto > sueldo) {
            println("Fondos insuficientes")
            return false
        }
        sueldo -= monto
        println("Descontado: \$${"%.2f".format(monto)} | Nuevo sueldo: ${consultarSueldo()}")
        return true
    }

    fun consultarSueldo(): String = "\$${"%.2f".format(sueldo)}"
}

fun main() {
    val emp = EmpleadoNomina("María García", 800.0)

    emp.asignarAumento(200.0)
    emp.descontar(50.0)
    emp.descontar(2000.0)

    println(emp.nombre)
    println(emp.consultarSueldo())
}
