data class Empleado(
    val id: Int,
    val nombre: String,
    val sueldo: Double,
    val departamento: String,
    val activo: Boolean = true
)

fun main() {
    val e1 = Empleado(1, "Ana Proaño", 1200.0, "Sistemas")
    val e2 = Empleado(1, "Ana Proaño", 1200.0, "Sistemas")
    val e3 = Empleado(2, "Luis Lema", 800.0, "Contabilidad")

    println(e1)
    println(e1 == e2)
    println(e1 == e3)

    val aumento = e1.copy(sueldo = 1400.0)
    val inactivo = e1.copy(activo = false)

    val (id, nombre, sueldo) = e1
    println("$id: $nombre — \$$sueldo")

    listOf(e1, e3).forEach { (id2, nombre2, sueldo2) ->
        println("[$id2] $nombre2: \$$sueldo2")
    }
}
