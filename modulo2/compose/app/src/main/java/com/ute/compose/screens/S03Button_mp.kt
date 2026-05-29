package com.ute.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S03Button_mpScreen() {
    var ultimoClick by remember { mutableStateOf("(ninguno)") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Acciones de Nómina - Botones",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Última acción: $ultimoClick",
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(Modifier.height(4.dp))

        Button(
            onClick = { ultimoClick = "Calcular Nómina" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Calcular Nómina") }

        Button(
            onClick = { ultimoClick = "Agregar empleado" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.PersonAdd,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text("Agregar Empleado")
        }

        OutlinedButton(
            onClick = { ultimoClick = "Exportar Reporte" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Exportar Reporte") }

        TextButton(
            onClick = { ultimoClick = "Ver detalle" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Ver Detalle de Nómina") }

        ElevatedButton(
            onClick = { ultimoClick = "Procesar Pago" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Procesar Pago") }

        FilledTonalButton(
            onClick = { ultimoClick = "Generar Rol" },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Generar Rol de Pagos") }

        Button(
            onClick = { },
            enabled = false,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Nómina ya procesada (deshabilitado)") }

        HorizontalDivider()

        EtiquetaSeccion("Acciones rápidas")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            IconButton(onClick = { ultimoClick = "Pago" }) {
                Icon(Icons.Default.Payments, contentDescription = "Pagar")
            }
            IconButton(onClick = { ultimoClick = "Reporte" }) {
                Icon(Icons.Default.Description, contentDescription = "Reporte",
                    tint = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S03_mpPreview() {
    MaterialTheme { S03Button_mpScreen() }
}
