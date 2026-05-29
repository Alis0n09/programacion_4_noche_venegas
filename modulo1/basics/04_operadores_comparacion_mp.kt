fun main() {
    var sueldo1 = 600.00
    var sueldo2 = 800.00

    println("=== Comparación de Sueldos ===")
    println("Sueldo1 == Sueldo2: ${sueldo1 == sueldo2}")
    println("Sueldo1 != Sueldo2: ${sueldo1 != sueldo2}")
    println("Sueldo1 > Sueldo2: ${sueldo1 > sueldo2}")
    println("Sueldo1 < Sueldo2: ${sueldo1 < sueldo2}")
    println("Sueldo1 >= Sueldo2: ${sueldo1 >= sueldo2}")
    println("Sueldo1 <= Sueldo2: ${sueldo1 <= sueldo2}")

    val empleado1 = "Juan Pérez"
    val empleado2 = "Juan Pérez"
    println("=== Referencia ===")
    println("empleado1 === empleado2: ${empleado1 === empleado2}")
    println("empleado1 == empleado2: ${empleado1 == empleado2}")
    println("empleado1.equals(empleado2): ${empleado1.equals(empleado2)}")
}
