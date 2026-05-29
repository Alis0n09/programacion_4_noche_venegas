enum class TipoContrato(val descripcion: String, val esTerminal: Boolean) {
    ACTIVO("Empleado activo en nómina", false),
    SUSPENDIDO("Suspensión temporal", false),
    LIQUIDADO("Contrato finalizado con liquidación", true),
    RENUNCIA("Renuncia voluntaria", true),
    DESPIDO("Despido por parte de la empresa", true);

    fun puedeTransicionarA(siguiente: TipoContrato): Boolean = when (this) {
        ACTIVO -> siguiente == SUSPENDIDO || siguiente == RENUNCIA || siguiente == DESPIDO
        SUSPENDIDO -> siguiente == ACTIVO || siguiente == RENUNCIA || siguiente == DESPIDO
        else -> false
    }
}

fun main() {
    val estado = TipoContrato.ACTIVO
    println(estado.descripcion)
    println(estado.esTerminal)

    val icono = when (estado) {
        TipoContrato.ACTIVO -> "✅"
        TipoContrato.SUSPENDIDO -> "⏸️"
        TipoContrato.LIQUIDADO -> "📄"
        TipoContrato.RENUNCIA -> "🚪"
        TipoContrato.DESPIDO -> "⚠️"
    }
    println(icono)

    println(estado.puedeTransicionarA(TipoContrato.SUSPENDIDO))
}
