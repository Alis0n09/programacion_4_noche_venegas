interface Exportable {
    val id: String
    fun exportar(): String
    val version: Int get() = 1
}

interface Validable2 {
    val errores: List<String>
    val esValido: Boolean get() = errores.isEmpty()

    fun validar(): Boolean
    fun imprimirErrores() {
        if (errores.isEmpty()) println("Sin errores")
        else errores.forEach { println("  ❌ $it") }
    }
}

data class RegistroEmpleado(
    override val id: String,
    val nombre: String,
    val sueldo: Double,
    val departamento: String
) : Exportable, Validable2 {

    override fun exportar() =
        "$id|$nombre|$sueldo|$departamento"

    override val errores: List<String> get() = buildList {
        if (nombre.isBlank()) add("El nombre no puede estar vacío")
        if (sueldo <= 0) add("El sueldo debe ser mayor que cero")
        if (departamento.isBlank()) add("El departamento no puede estar vacío")
    }

    override fun validar() = esValido
}

fun main() {
    val r1 = RegistroEmpleado("E001", "Ana Lopez", 1200.0, "Sistemas")
    val r2 = RegistroEmpleado("E002", "", -5.0, "")

    fun procesarExportable(s: Exportable) = println("→ ${s.exportar()}")
    fun procesarValidable2(v: Validable2) {
        println("Valido: ${v.esValido}")
        v.imprimirErrores()
    }

    procesarExportable(r1)
    procesarValidable2(r1)
    procesarValidable2(r2)
}
