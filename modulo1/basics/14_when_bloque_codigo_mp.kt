fun main() {
    println("=== Tipo de Contrato ===")
    println("Nombre del empleado:")
    val nombre = readLine()?.trim() ?: ""
    println("Tipo de contrato (FIJO/INDEFINIDO/TEMPORAL/PRACTICAS):")
    val tipo = readLine()?.trim()?.uppercase() ?: ""

    when (tipo) {
        "FIJO" -> {
            println("CONTRATO FIJO - $nombre")
            println("Duración: 1 año renovable")
            println("Beneficios: décimos, vacaciones, fondos de reserva")
        }
        "INDEFINIDO" -> {
            println("CONTRATO INDEFINIDO - $nombre")
            println("Estabilidad laboral completa")
            println("Beneficios: todos según Código de Trabajo")
        }
        "TEMPORAL" -> println("Temporal: $nombre, duración máxima 6 meses")
        "PRACTICAS" -> println("Prácticas: $nombre, convenio educativo")
        else -> println("Tipo de contrato no reconocido")
    }

    println("Edad:")
    val edad = readLine()?.toIntOrNull() ?: 0
    val rangoSalarial = when (edad) {
        in 18..25 -> "Salario inicial"
        in 26..35 -> "Salario medio"
        in 36..50 -> "Salario senior"
        else -> "Salario experimentado"
    }
    println("$edad años -> $rangoSalarial")
}
