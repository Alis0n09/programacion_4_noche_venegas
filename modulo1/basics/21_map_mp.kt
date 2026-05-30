fun main() {
    println("--- Map de Sueldos por Empleado ---")
    println("Inmutable")
    val sueldos = mapOf(
        "Gabriela Lopez" to 1200.0,
        "Luis Perez" to 800.0,
        "Canelo Ruiz" to 1500.0,
        "Pedro Ortiz" to 950.0
    )
    println(sueldos["Gabriela Lopez"])
    println(sueldos["Luis Perez"])
    println(sueldos.getOrDefault("Gabriela Lopez", 0.0))
    println(sueldos.getOrDefault("Luis Perez", 0.0))
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
        "Gabriela Lopez" to 100,
        "Luis Perez" to 50,
        "Canelo Ruiz" to 200
    )
    bonos["Pedro Ortiz"] = 75
    println(bonos)
    bonos["Ana Lopez"] = 150
    println(bonos)
    bonos.remove("Luis Perez")
    println(bonos)
    bonos.getOrPut("Sofia Paz") { 80 }
    println(bonos)
    bonos.getOrPut("Ana Lopez") { 80 }
    println(bonos)
}
