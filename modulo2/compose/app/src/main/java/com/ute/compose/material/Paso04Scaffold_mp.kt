package com.ute.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ute.compose.model.empleadosDeMuestra

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paso04Scaffold_mpScreen() {
    var empleados by remember { mutableStateOf(empleadosDeMuestra) }
    var busqueda by remember { mutableStateOf("") }
    var filtro by remember { mutableStateOf("Todos") }
    var mostrarFab by remember { mutableStateOf(false) }

    val empleadosFiltrados = empleados
        .filter { empleado ->
            when (filtro) {
                "Administrativo" -> empleado.departamento == "Administrativo"
                "Contabilidad" -> empleado.departamento == "Contabilidad"
                "Sistemas" -> empleado.departamento == "Sistemas"
                else -> true
            }
        }
        .filter { empleado ->
            busqueda.isBlank() ||
                    empleado.nombre.contains(busqueda, ignoreCase = true) ||
                    empleado.departamento.contains(busqueda, ignoreCase = true)
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Control Nomina (${empleados.size})",
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(onClick = {
                        filtro = if (filtro == "Todos") "Sistemas" else "Todos"
                    }) {
                        Icon(
                            imageVector = Icons.Default.Badge,
                            contentDescription = "Filtrar empleados",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { mostrarFab = true }
            ) {
                Icon(
                    Icons.Default.PersonAdd,
                    contentDescription = "Nuevo empleado"
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = busqueda,
                onValueChange = { busqueda = it },
                placeholder = { Text("Buscar empleado o departamento...") },
                leadingIcon = { Icon(Icons.Default.Search, null) },
                trailingIcon = {
                    if (busqueda.isNotEmpty()) {
                        IconButton(onClick = { busqueda = "" }) {
                            Icon(Icons.Default.Clear, "Limpiar")
                        }
                    }
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(
                    listOf(
                        "Todos",
                        "Administrativo",
                        "Contabilidad",
                        "Sistemas"
                    )
                ) { opcion ->
                    FilterChip(
                        selected = filtro == opcion,
                        onClick = { filtro = opcion },
                        label = { Text(opcion) },
                        leadingIcon = if (filtro == opcion) {{
                            Icon(
                                Icons.Default.Check,
                                null,
                                Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }} else null
                    )
                }
            }

            Spacer(Modifier.height(4.dp))

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        "${empleadosFiltrados.size} empleado(s) encontrados",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }

                items(
                    items = empleadosFiltrados,
                    key = { it.id }
                ) { empleado ->
                    TarjetaEmpleado(
                        empleado = empleado,
                        onClick = { },
                        onPagar = { },
                        onDetalle = { }
                    )
                }

                item { Spacer(Modifier.height(80.dp)) }
            }
        }
    }

    if (mostrarFab) {
        AlertDialog(
            onDismissRequest = { mostrarFab = false },
            title = { Text("Nuevo empleado") },
            text = {
                Text("Aquí se podrá registrar un empleado para generar su rol de pagos, sueldo, aportes al IESS y beneficios de ley.")
            },
            confirmButton = {
                TextButton(onClick = { mostrarFab = false }) {
                    Text("OK")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Paso04mpPreview() {
    MaterialTheme {
        Paso04Scaffold_mpScreen()
    }
}