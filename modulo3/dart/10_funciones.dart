void saludar() {
  print('Hola mundo');
}

void saludoConParametro(String nombre) {
  print('Hola $nombre');
}

int obtenerNumero(){
  return 10;
}

int sumar(int a, int b) {
  return a + b;
}

int multiplicar(int a, int b) => a*b;


void  saludarOpcional(String nombre, [String apellido='Sin apellido']){
  print ("Hola $nombre $apellido");
}

void registroCliente({
  required String nombre,
  required int edad,
}){
  print("Hola $nombre edad: $edad");
}
// Con tipo explícito — recomendado
String formatearPrecio(double precio) => '\$${precio.toStringAsFixed(2)}';

// Sin tipo — Dart infiere que retorna String
formatearPrecioSinTipo(double precio) => '\$${precio.toStringAsFixed(2)}';

void main() {
  saludar();
  saludoConParametro('Pedro Perez');
  int numero = obtenerNumero();
  print(numero);
  print('El numero es: ${obtenerNumero()}');
  print('La suma es: ${sumar(5,5)}');
  print('La multiplicacion es: ${multiplicar(5,5)}');
  saludarOpcional("Alison");
  saludarOpcional("Alison", "Venegas");
  registroCliente(nombre: 'Ana', edad: 22);
  print(formatearPrecio(1299.9)); 
}