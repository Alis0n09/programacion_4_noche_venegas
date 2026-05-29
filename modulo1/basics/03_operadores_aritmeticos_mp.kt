fun main() {
    var sueldoBase = 460.00
    var horasExtras = 10

    println("----- Calculo de Nomina -----")
    println("Sueldo base: \$$sueldoBase")
    println("Horas extras: $horasExtras")
    println("Valor hora extra: \$4.50")
    println("Total horas extras: \$" + (horasExtras * 4.50))
    println("Sueldo bruto: \$" + (sueldoBase + horasExtras * 4.50))
    println("Descuento 9.45% IESS: \$" + (sueldoBase * 0.0945))
    println("Sueldo neto: \$" + (sueldoBase + horasExtras * 4.50 - sueldoBase * 0.0945))

    println("--- Operadores Aritmeticos ---")
    var total = 0
    total += 500
    println("Total += 500: \$$total")
    total -= 100
    println("Total -= 100: \$$total")
    total *= 2
    println("Total *= 2: \$$total")
    total /= 4
    println("Total /= 4: \$$total")
    total %= 3
    println("Total %= 3: \$$total")

    var contador = 0
    contador++
    println("Empleados procesados: $contador")
}
