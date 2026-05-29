fun main() {
    println("=== Map de Sueldos por Empleado ===")
    println("Inmutable")
    val sueldos = mapOf(
        "Ana López" to 1200.0,
        "Luis Vera" to 800.0,
        "Carmen Ruiz" to 1500.0,
        "Pedro Salas" to 950.0
    )
    println(sueldos["Ana López"])
    println(sueldos["Carlos"])
    println(sueldos.getOrDefault("Ana López", 0.0))
    println(sueldos.getOrDefault("Carlos", 0.0))
    println(sueldos.keys)
    println(sueldos.values)
    for ((empleado, sueldo) in sueldos) {
        println("$empleado: \$$sueldo")
    }
    for (sueldo in sueldos) {
        println("${sueldo.key}: \$${sueldo.value}")
    }

    println("Mutable")
    val bonos = mutableMapOf(
        "Ana López" to 100,
        "Luis Vera" to 50,
        "Carmen Ruiz" to 200
    )
    bonos["Pedro Salas"] = 75
    println(bonos)
    bonos["Ana López"] = 150
    println(bonos)
    bonos.remove("Luis Vera")
    println(bonos)
    bonos.getOrPut("Sofía Paz") { 80 }
    println(bonos)
    bonos.getOrPut("Ana López") { 80 }
    println(bonos)
}
