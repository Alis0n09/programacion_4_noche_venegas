data class Departamento(val id: Int, val nombre: String)

data class Empleado(
    val id: Int,
    val nombre: String,
    val sueldo: Double,
    val horas: Int,
    val departamento: Departamento,
    val activo: Boolean = true
) {
    val disponible: Boolean get() = activo && horas > 0
    val sueldoBruto: Double get() = sueldo + (horas * 4.50)

    fun aplicarAumento(porcentaje: Double): Empleado {
        require(porcentaje in 0.0..100.0) { "Aumento debe ser entre 0 y 100" }
        return copy(sueldo = sueldo * (1 + porcentaje / 100))
    }
}

object NominaEmpresa {
    private val departamentos = mutableListOf(
        Departamento(1, "Sistemas"),
        Departamento(2, "Contabilidad"),
        Departamento(3, "Ventas")
    )
    private val empleados = mutableListOf<Empleado>()
    private var siguienteId = 1

    fun contratar(nombre: String, sueldo: Double, horas: Int, deptoId: Int): Empleado? {
        val depto = departamentos.find { it.id == deptoId } ?: return null
        val emp = Empleado(siguienteId++, nombre, sueldo, horas, depto)
        empleados.add(emp)
        return emp
    }

    fun listar(): List<Empleado> = empleados.toList()
    fun activos(): List<Empleado> = empleados.filter { it.disponible }
    fun porDepartamento(id: Int): List<Empleado> = empleados.filter { it.departamento.id == id }
    fun buscar(query: String): List<Empleado> =
        empleados.filter { it.nombre.contains(query, ignoreCase = true) }
}

fun main() {
    NominaEmpresa.contratar("Ana López", 1200.0, 160, 1)
    NominaEmpresa.contratar("Luis Vera", 800.0, 0, 2)
    NominaEmpresa.contratar("Carmen Ruiz", 1500.0, 160, 3)
    NominaEmpresa.contratar("Pedro Salas", 950.0, 140, 1)

    println("=== Todos los empleados ===")
    NominaEmpresa.listar().forEach { e ->
        println("${e.nombre} — Sueldo bruto: \$${"%.2f".format(e.sueldoBruto)}")
    }

    println("\n=== Activos con aumento 10% ===")
    NominaEmpresa.activos()
        .map { it.aplicarAumento(10.0) }
        .forEach { println("${it.nombre}: \$${"%.2f".format(it.sueldo)}") }

    println("\n=== Todos los empleados ===")
    for (e in NominaEmpresa.listar()) {
        println("Nombre: ${e.nombre} - Horas: ${e.horas}")
    }
}
