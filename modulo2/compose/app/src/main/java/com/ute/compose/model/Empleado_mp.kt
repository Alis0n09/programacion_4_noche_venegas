package com.ute.compose.model

data class Empleado(
    val id: Int,
    val nombre: String,
    val cedula: String,
    val sueldo: Double,
    val departamento: String,
    val activo: Boolean = true
)

val empleadosDeMuestra = listOf(
    Empleado(1, "Alison Venegas", "1712345678", 1200.0, "Sistemas", activo = true),
    Empleado(2, "Luis Martinez", "1712345679", 800.0, "Contabilidad"),
    Empleado(3, "Gabriela Calderon", "1712345680", 1500.0, "Ventas", activo = true),
    Empleado(4, "Carlos Lopez", "1712345681", 950.0, "Producción"),
    Empleado(5, "Andres Torres", "1712345682", 1100.0, "RRHH"),
    Empleado(6, "Pedro Morales", "1712345683", 600.0, "Logística"),
    Empleado(7, "Elena Vega", "1712345684", 2000.0, "Gerencia", activo = true),
    Empleado(8, "Diego Pazmiño", "1712345685", 700.0, "Mantenimiento"),
)
