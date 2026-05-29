package com.ute.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ute.compose.model.Empleado
import com.ute.compose.model.empleadosDeMuestra

data class DestinoNavN(
    val ruta: String,
    val etiqueta: String,
    val iconoActivo: ImageVector,
    val iconoInactivo: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paso05NavBar_mpScreen() {
    var destinoActual by remember { mutableStateOf("empleados") }
    var empleados by remember { mutableStateOf(empleadosDeMuestra) }

    val destinos = listOf(
        DestinoNavN("empleados", "Empleados", Icons.Filled.People, Icons.Outlined.People),
        DestinoNavN("pagos", "Pagos", Icons.Filled.Payments, Icons.Outlined.Payments),
        DestinoNavN("resumen", "Resumen", Icons.Filled.Assessment, Icons.Outlined.Assessment),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Nómina Ecuador",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        bottomBar = {
            NavigationBar {
                destinos.forEach { destino ->
                    val seleccionado = destinoActual == destino.ruta

                    NavigationBarItem(
                        selected = seleccionado,
                        onClick = { destinoActual = destino.ruta },
                        icon = {
                            Icon(
                                imageVector = if (seleccionado)
                                    destino.iconoActivo
                                else
                                    destino.iconoInactivo,
                                contentDescription = destino.etiqueta
                            )
                        },
                        label = { Text(destino.etiqueta) }
                    )
                }
            }
        },

        floatingActionButton = {
            if (destinoActual == "empleados") {
                FloatingActionButton(onClick = { }) {
                    Icon(
                        Icons.Default.PersonAdd,
                        contentDescription = "Nuevo empleado"
                    )
                }
            }
        }

    ) { paddingValues ->

        when (destinoActual) {
            "empleados" -> PantallaEmpleadosContent(
                empleados = empleados,
                modifier = Modifier.padding(paddingValues)
            )

            "pagos" -> PantallaPagosContent(
                empleados = empleados,
                modifier = Modifier.padding(paddingValues)
            )

            "resumen" -> PantallaResumenNominaContent(
                empleados = empleados,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
private fun PantallaEmpleadosContent(
    empleados: List<Empleado>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                "Empleados registrados",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        items(
            items = empleados,
            key = { it.id }
        ) { empleado ->
            TarjetaEmpleado(
                empleado = empleado,
                onClick = {},
                onPagar = {},
                onDetalle = {}
            )
        }

        item { Spacer(Modifier.height(80.dp)) }
    }
}

@Composable
fun PantallaPagosContent(
    empleados: List<Empleado>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                "Roles de pago pendientes",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        items(
            items = empleados,
            key = { it.id }
        ) { empleado ->
            ElevatedCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        empleado.nombre,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        "Departamento: ${empleado.departamento}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(Modifier.height(8.dp))

                    Text("Sueldo mensual: $${empleado.sueldo}")
                    Text("Aporte personal IESS: 9.45%")
                    Text("Estado: Pendiente de generar rol")
                }
            }
        }
    }
}

@Composable
fun PantallaResumenNominaContent(
    empleados: List<Empleado>,
    modifier: Modifier = Modifier
) {
    val totalSueldos = empleados.sumOf { it.sueldo }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Icon(
                Icons.Default.Assessment,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(Modifier.height(12.dp))

            Text(
                "Resumen de Nómina",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(8.dp))

            Text("Total de empleados: ${empleados.size}")
            Text("Total sueldos: $$totalSueldos")
            Text("Cálculo aplicado: IESS 9.45%")
            Text("Beneficios: décimos y fondos de reserva")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso05mpPreview() {
    MaterialTheme {
        Paso05NavBar_mpScreen()
    }
}