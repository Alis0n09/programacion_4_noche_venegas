interface Pagable {
    fun procesarPago(monto: Double): Boolean
    val nombre: String
}

class TransferenciaBancaria(val cuenta: String) : Pagable {
    override val nombre = "Transferencia bancaria"
    override fun procesarPago(monto: Double): Boolean {
        println("Transferencia de \$${"%.2f".format(monto)} a cuenta $cuenta")
        return true
    }
}

class Efectivo : Pagable {
    override val nombre = "Efectivo"
    override fun procesarPago(monto: Double): Boolean {
        println("Pago en efectivo: \$${"%.2f".format(monto)}")
        return true
    }
}

class Cheque(val numero: String, val banco: String) : Pagable {
    override val nombre = "Cheque"
    override fun procesarPago(monto: Double): Boolean {
        println("Cheque No.$numero del $banco por \$${"%.2f".format(monto)}")
        return true
    }
}

fun pagar(monto: Double, metodo: Pagable) {
    println("Procesando con ${metodo.nombre}...")
    val exito = metodo.procesarPago(monto)
    println(if (exito) "✅ Pago exitoso\n" else "❌ Pago fallido\n")
}

fun main() {
    val metodos: List<Pagable> = listOf(
        TransferenciaBancaria("1234567890"),
        Efectivo(),
        Cheque("001-789", "Banco Pichincha")
    )

    println("=== PAGO DE NÓMINA ===")
    for (metodo in metodos) {
        pagar(1500.0, metodo)
    }
}
