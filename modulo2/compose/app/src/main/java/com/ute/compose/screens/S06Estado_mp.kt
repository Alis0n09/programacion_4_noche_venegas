package com.ute.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun S06Estado_mpScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Estado de Nómina - Recomposición",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        DemoContadorEmpleados()
        HorizontalDivider()
        DemoNivelSalarial()
    }
}

@Composable
private fun DemoContadorEmpleados() {
    var cuenta by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        EtiquetaSeccion("Contador de empleados — remember + mutableStateOf")

        Text(
            text = "$cuenta",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { cuenta-- }) { Text("−") }
            Button(onClick = { cuenta++ }) { Text("+") }
            OutlinedButton(onClick = { cuenta = 0 }) { Text("Reset") }
        }

        Text(
            "Empleados registrados: $cuenta",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun DemoNivelSalarial() {
    var nivel by remember { mutableStateOf(0) }
    val max = 5

    val porcentaje = nivel.toFloat() / max
    val etiquetaNivel = when {
        nivel == 0 -> "Sin salario"
        nivel <= 2 -> "Salario básico"
        nivel <= 4 -> "Salario medio"
        else -> "Salario alto"
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        EtiquetaSeccion("Nivel salarial — estado derivado")

        Text(
            "$etiquetaNivel (nivel $nivel/$max)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        LinearProgressIndicator(
            progress = { porcentaje },
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .clip(RoundedCornerShape(6.dp))
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(
                onClick = { if (nivel > 0) nivel-- },
                enabled = nivel > 0
            ) { Text("Bajar nivel") }

            Button(
                onClick = { if (nivel < max) nivel++ },
                enabled = nivel < max
            ) { Text("Subir nivel") }
        }

        Text(
            "Salario estimado: \$" + (460 + nivel * 200) + " — derivado del nivel",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun S06_mpPreview() {
    MaterialTheme { S06Estado_mpScreen() }
}
