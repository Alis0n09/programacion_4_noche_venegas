fun main() {
    val empresa = "Corporación Ecuador S.A."
    val ruc: String = "1791234567001"
    var sueldoBase = 460.00
    sueldoBase = sueldoBase + 40.00

    println("Empresa: $empresa - RUC: $ruc")
    println("Sueldo básico unificado: \$$sueldoBase")

    val horasTrabajadas: Byte = 60
    val valorHora: Short = 4_50
    val totalIngresos: Int = (horasTrabajadas * valorHora).toInt()
    val cedula: Long = 1234567890L

    println("Horas: $horasTrabajadas - Valor hora: \$$valorHora")
    println("Total ingresos: \$$totalIngresos")
    println("Cédula: $cedula")

    val bono: Float = 50.75f
    val totalPagar: Double = totalIngresos.toDouble() + bono

    val tipoContrato: Char = 'F'
    val nombreEmpleado: String = "Vicoria Lopez"
    val inferido = "Nomina"

    println("$nombreEmpleado - Tipo: $tipoContrato - Total: \$$totalPagar")
    println("Tipo de inferido: ${inferido::class.simpleName}")

    val apellido = "lopez"
    val apellidoMayus = apellido.uppercase()
    println("Apellido: $apellidoMayus")
}
