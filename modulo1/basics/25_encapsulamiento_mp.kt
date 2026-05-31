class Sueldo(valor: Double) {

    var valor: Double = valor
        set(value) {
            require(value >= 460.0) { "Sueldo no puede ser menor al basico unificado" }
            field = value
        }

    val decimoTercero: Double
        get() = valor / 12

    val decimoCuarto: Double
        get() = valor / 12

    val descripcion: String
        get() = when {
            valor < 500 -> "Salario minimo"
            valor < 800 -> "Salario medio-bajo"
            valor < 1200 -> "Salario medio"
            valor < 2000 -> "Salario alto"
            else -> "Salario ejecutivo"
        }
}

fun main() {
    val s = Sueldo(800.0)
    println("Sueldo: \$${s.valor}")
    println("Decimo tercero: \$${"%.2f".format(s.decimoTercero)}")
    println("Decimo cuarto: \$${"%.2f".format(s.decimoCuarto)}")
    println(s.descripcion)

    s.valor = 500.0
    println("Nuevo: \$${s.valor} → ${s.descripcion}")
}
