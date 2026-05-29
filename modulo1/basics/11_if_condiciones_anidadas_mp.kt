fun main() {
    println("=== Cálculo de Bonos ===")
    print("El empleado cumplió metas? s/n ")
    val cumpleMetas = readLine()?.trim()?.lowercase() == "s"
    println("Antigüedad en años:")
    val antiguedad = readLine()?.toIntOrNull() ?: 0
    if (cumpleMetas) {
        println("Empleado cumplió metas")
        if (antiguedad < 2) {
            println("Bono: \$50")
        } else if (antiguedad < 5) {
            println("Bono: \$150")
        } else {
            println("Bono: \$300")
        }
    } else {
        println("Empleado no cumplió metas")
        if (antiguedad >= 5) {
            println("Bono antigüedad: \$100")
        } else {
            println("Sin bono")
        }
    }
}
