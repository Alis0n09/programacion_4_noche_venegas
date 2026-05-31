interface A { fun calcular() = println("Cálculo desde A (sueldo base)") }
interface B { fun calcular() = println("Cálculo desde B (con bonos)") }

class C : A, B {
    override fun calcular() {
        super<A>.calcular()
        super<B>.calcular()
        println("Y desde C (nómina completa)")
    }
}

fun main() {
    val obj = C()
    obj.calcular()
}
