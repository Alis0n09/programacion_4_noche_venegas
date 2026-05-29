package com.ute.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S07StateHoisting_mpScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("State Hoisting - Nomina",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        DemoEstadoAtrapado()
        HorizontalDivider()
        DemoEstadoElevado()
    }
}

@Composable
private fun DemoEstadoAtrapado() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        EtiquetaSeccion("Estado atrapado — sin acceso del padre")

        Text(
            "El contador de empleados vive dentro del botón. " +
                    "El padre no puede leerlo ni usarlo.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        BotonContadorAtrapado()

        Text(
            "El padre no puede mostrar el total aquí",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
private fun BotonContadorAtrapado() {
    var cuenta by remember { mutableStateOf(0) }
    Button(onClick = { cuenta++ }) {
        Text("Empleados: $cuenta (estado atrapado)")
    }
}

@Composable
private fun DemoEstadoElevado() {
    var seleccion by remember { mutableStateOf<String?>(null) }
    var historial by remember { mutableStateOf(listOf<String>()) }

    val tiposContrato = listOf("FIJO", "INDEFINIDO", "TEMPORAL", "PRÁCTICAS")

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        EtiquetaSeccion("Estado elevado — el padre coordina")

        Text(
            "El hijo solo notifica el tipo seleccionado. " +
                    "El padre actualiza selección e historial.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        SelectorTipoContrato(
            opciones = tiposContrato,
            seleccion = seleccion,
            onSeleccion = { opcion ->
                seleccion = opcion
                historial = (historial + opcion).takeLast(4)
            }
        )

        seleccion?.let { sel ->
            val color = when {
                "FIJO" in sel -> Color(0xFFFFCDD2)
                "INDEFINIDO" in sel -> Color(0xFFC8E6C9)
                "TEMPORAL" in sel -> Color(0xFFBBDEFB)
                else -> Color(0xFFFFF9C4)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Text("Contrato: $sel",
                    style = MaterialTheme.typography.labelLarge)
            }
        }

        if (historial.isNotEmpty()) {
            Text(
                "Historial: ${historial.joinToString(" → ")}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SelectorTipoContrato(
    opciones: List<String>,
    seleccion: String?,
    onSeleccion: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        opciones.forEach { opcion ->
            val estaSeleccionado = seleccion == opcion
            Button(
                onClick = { onSeleccion(opcion) },
                modifier = Modifier.fillMaxWidth(),
                colors = if (estaSeleccionado)
                    ButtonDefaults.buttonColors()
                else
                    ButtonDefaults.outlinedButtonColors()
            ) {
                Text(opcion)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S07_mpPreview() {
    MaterialTheme { S07StateHoisting_mpScreen() }
}
