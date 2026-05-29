package com.ute.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ute.compose.model.Empleado
import com.ute.compose.model.empleadosDeMuestra

@Composable
fun S08Bienvenida_mpScreen() {
    var filtro by remember { mutableStateOf("") }
    var empleadoSeleccionado by remember { mutableStateOf<Empleado?>(null) }
    var mostrarDialogo by remember { mutableStateOf(false) }

    val empleadosFiltrados = if (filtro.isBlank()) empleadosDeMuestra
    else empleadosDeMuestra.filter {
        it.nombre.contains(filtro, ignoreCase = true) ||
        it.cedula.contains(filtro)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Bienvenido al Sistema de Nómina",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Total empleados activos: ${empleadosDeMuestra.count { it.activo }}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = filtro,
            onValueChange = { filtro = it },
            label = { Text("Buscar empleado") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        empleadosFiltrados.forEach { empleado ->
            ElevatedCard(
                onClick = { empleadoSeleccionado = empleado },
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(
                                if (empleado.activo) MaterialTheme.colorScheme.primaryContainer
                                else MaterialTheme.colorScheme.surfaceVariant
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = empleado.nombre.first().uppercase(),
                            fontWeight = FontWeight.Bold,
                            color = if (empleado.activo) MaterialTheme.colorScheme.onPrimaryContainer
                            else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(empleado.nombre, fontWeight = FontWeight.SemiBold)
                        Text(
                            text = "${empleado.departamento} · \$${empleado.sueldo}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    if (empleado.activo) {
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = MaterialTheme.colorScheme.primaryContainer
                        ) {
                            Text(
                                "Activo",
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S08_mpPreview() {
    MaterialTheme { S08Bienvenida_mpScreen() }
}
