package com.ute.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NominaApp() {
    S01Saludo_mpScreen()
}

@Composable
fun SaludoNomina(nombre: String) {
    Text(text = "Empleado: $nombre")
}

@Composable
fun S01Saludo_mpScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sistema de Control de Nómina Ecuador",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        SaludoNomina("Ana García - \$1200")
        SaludoNomina("Luis Vera - \$800")
        SaludoNomina("Sistema Nómina v1.0")

        HorizontalDivider()

        MensajeActivo(activo = true)
        MensajeActivo(activo = false)
    }
}

@Composable
private fun MensajeActivo(activo: Boolean) {
    if (activo) {
        Text("✅ Empleado activo en nómina")
    } else {
        Text("(Empleado inactivo - no visible en nómina)",
            color = MaterialTheme.colorScheme.outline)
    }
}

@Preview(showBackground = true)
@Composable
fun S01_mpPreview() {
    MaterialTheme { S01Saludo_mpScreen() }
}
