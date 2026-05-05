fun main() {
    println("Control de Flujo")
    println("If simple")
    println("Temperatura corporal del paciente grados centigrados")
    
    val temperatura= readLine()?.toDoubleOrNull()?:35.5 
    if(temperatura>38){
        println("Fiebre detectada")
    }
    if(temperatura>=40){
        println("Fiebre alta")
    }
    
    println("Temperatura registrada: $temperatura")
    

}