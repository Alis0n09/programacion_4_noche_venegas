fun main() {
    println("=== CICLO while - Validación de Nómina ===")
    var empleado = 1
    while (empleado <= 5) {
        print("Validando empleado #$empleado ")
        empleado++
    }
    println()
    empleado = 1
    do {
        println("Procesando empleado #$empleado")
        empleado++
    } while (empleado <= 5)

    println("break - continue")
    empleado = 1
    while (empleado <= 10) {
        empleado++
        if (empleado == 3) continue
        if (empleado == 7) break
        println("Empleado #$empleado")
    }

    var input: String
    while (true) {
        println("Escriba 'fin' para cerrar nómina:")
        input = readLine() ?: ""
        if (input == "fin") break
        println("Procesando: $input")
    }
}
