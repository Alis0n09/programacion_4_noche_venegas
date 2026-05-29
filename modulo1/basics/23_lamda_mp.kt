fun main() {
    println("=== Funciones Lambda en Nómina ===")
    val sumaSueldos: (Double, Double) -> Double = { a: Double, b: Double -> a + b }
    println(sumaSueldos(460.0, 100.0))
    val descuentoIESS: (Double) -> Double = { it * 0.0945 }
    println("Descuento IESS de \$800: \$${descuentoIESS(800.0)}")
    val duplicarBono: (Int) -> Int = { it * 2 }
    println("Bono duplicado: ${duplicarBono(50)}")
}
