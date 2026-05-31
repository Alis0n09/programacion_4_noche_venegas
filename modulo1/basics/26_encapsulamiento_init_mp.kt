class Empleado(val nombre: String, val email: String, val sueldo: Double) {
    val nombreNormalizado: String
    val dominioEmail: String

    init {
        require(nombre.isNotBlank()) { "El nombre no puede estar vacio" }
        require(email.contains("@")) { "Email invalido: $email" }
        require(sueldo >= 460.0) { "Sueldo debe ser >= basico unificado" }

        nombreNormalizado = nombre.trim().lowercase()
        dominioEmail = email.substringAfter("@")
    }
}

fun main() {
    val e = Empleado("  Carlos Vera  ", "carlos@empresa.com", 800.0)
    println(e.nombreNormalizado)
    println(e.dominioEmail)
}
