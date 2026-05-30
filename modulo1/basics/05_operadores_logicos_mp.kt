fun main() {
    println("--- Validacion de Bonos Nomina ---")
    val cumpleHoras = true
    val sinFaltas = false
    val evaluacionPositiva = true
    val antiguedadMinima = false

    println("Operador AND &&")
    println("$cumpleHoras && $sinFaltas: ${cumpleHoras && sinFaltas}")
    println("$cumpleHoras && $evaluacionPositiva: ${cumpleHoras && evaluacionPositiva}")

    println("Operador OR ||")
    println("$cumpleHoras || $sinFaltas: ${cumpleHoras || sinFaltas}")
    println("$antiguedadMinima || $sinFaltas: ${antiguedadMinima || sinFaltas}")
    println("$antiguedadMinima || $sinFaltas || $evaluacionPositiva: ${antiguedadMinima || sinFaltas || evaluacionPositiva}")

    println("NOT !")
    println("!$cumpleHoras: ${!cumpleHoras}")
    println("!$antiguedadMinima: ${!antiguedadMinima}")
}
