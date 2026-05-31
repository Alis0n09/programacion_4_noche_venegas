fun main() {
    println("--- Filtros de Nómina ---")
    val sueldos = listOf(460.0, 600.0, 850.0, 1200.0, 1500.0, 2000.0, 3000.0)
    println(sueldos)
    val conImpuesto = sueldos.map { it * 0.95 }
    println("Sueldos con impuesto: $conImpuesto")
    val etiquetados = sueldos.map { "Sueldo: \$$it" }
    println(etiquetados)

    println("Filter - Sueldos sobre 1000")
    val altos = sueldos.filter { it > 1000 }
    println(altos)
    val sobreIess = sueldos.filter { it > 600 }
    println("Sobre base IESS: $sobreIess")
    val altosYConDescuento = sueldos.filter { it > 1000 && it < 2500 }
    println("Entre 1000 y 2500: $altosYConDescuento")
    val bajos = sueldos.filterNot { it > 600 }
    println("Sueldos bajos: $bajos")
}
