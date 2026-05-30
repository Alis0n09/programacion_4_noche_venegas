object ConfiguracionEmpresa {
    val nombre: String = "Corporacion Ecuador S.A."
    val ruc: String = "1791234567001"
    private val claveContabilidad: String = "clave-secreta-123"

    fun obtenerInfo() = "$nombre - RUC: $ruc"
    fun encabezadoNomina() = mapOf("Empresa" to nombre, "RUC" to ruc)
}

class EmpleadoSistema private constructor(val id: Int, val nombre: String) {
    companion object {
        private var contadorId = 0

        fun crear(nombre: String, email: String): EmpleadoSistema? {
            if (nombre.isBlank() || !email.contains("@")) return null
            return EmpleadoSistema(++contadorId, nombre.trim())
        }

        const val ROL_DEFECTO = "empleado"
    }
}

fun main() {
    println(ConfiguracionEmpresa.obtenerInfo())

    val e = EmpleadoSistema.crear("Ana", "ana@empresa.com")
    println(e)
}
