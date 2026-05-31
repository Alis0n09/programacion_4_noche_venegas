package com.ute.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ute.compose.model.Empleado
import com.ute.compose.model.empleadosDeMuestra
@Composable
fun Paso03LazyColumnmpScreen() {

    var empleados by remember { mutableStateOf(empleadosDeMuestra) }
    var busqueda by remember { mutableStateOf("") }
    var filtro by remember { mutableStateOf("Todos") }

    val empleadosFiltrados = empleados
        .filter { empleado ->
            when (filtro) {
                "Activos" -> empleado.activo
                else -> true
            }
        }
        .filter { empleado ->
            busqueda.isBlank() ||
                    empleado.nombre.contains(busqueda, ignoreCase = true) ||
                    empleado.departamento.contains(busqueda, ignoreCase = true)
        }

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            "Sistema de Nómina Ecuador",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )

        OutlinedTextField(
            value = busqueda,
            onValueChange = { busqueda = it },
            placeholder = { Text("Buscar empleado...") },
            leadingIcon = {
                Icon(Icons.Default.Search, null)
            },
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
                .padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {

            items(listOf("Todos", "Activos")) { opcion ->

                FilterChip(
                    selected = filtro == opcion,
                    onClick = { filtro = opcion },
                    label = { Text(opcion) }
                )
            }
        }

        Spacer(Modifier.height(8.dp))

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            item {
                Text(
                    "${empleadosFiltrados.size} empleado(s) registrados",
                    style = MaterialTheme.typography.labelMedium
                )
            }

            items(empleadosFiltrados) { empleado ->

                TarjetaEmpleado(
                    empleado = empleado,
                    onClick = {},
                    onPagar = {},
                    onDetalle = {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso03mpPreview() {
    MaterialTheme { Paso03LazyColumnmpScreen() }
}