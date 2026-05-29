package com.ute.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun S05Modifier_mpScreen() {
    var ultimoClick by remember { mutableStateOf("Seleccione un empleado") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Modifier en Nómina",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(ultimoClick, Modifier.padding(12.dp),
                style = MaterialTheme.typography.bodySmall)
        }

        EtiquetaSeccion("1. Avatar empleado (clip antes de background)")
        Box(
            modifier = Modifier
                .size(130.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
                .padding(12.dp)
                .clickable { ultimoClick = "Perfil de empleado ✅" },
            contentAlignment = Alignment.Center
        ) {
            Text("Empleado\ndel Mes ✅",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer)
        }

        EtiquetaSeccion("2. Error común (background antes de clip)")
        Box(
            modifier = Modifier
                .size(130.dp)
                .background(Color(0xFFFFCDD2))
                .clip(RoundedCornerShape(16.dp))
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Sin recorte\ncorrecto ❌",
                style = MaterialTheme.typography.labelSmall)
        }

        EtiquetaSeccion("3. Iniciales departamento (CircleShape)")
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            listOf("S" to Color(0xFF1976D2), "C" to Color(0xFF388E3C), "V" to Color(0xFFF57C00))
                .forEach { (letra, color) ->
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(color)
                            .clickable { ultimoClick = "Depto $letra presionado" },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(letra, color = Color.White,
                            style = MaterialTheme.typography.titleMedium)
                    }
                }
        }

        EtiquetaSeccion("4. fillMaxWidth + padding asimétrico")
        Text(
            text = "Sueldo: \$1,200.00 | Descuento: \$113.40 | Neto: \$1,086.60",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE8F5E9))
                .padding(horizontal = 32.dp, vertical = 8.dp)
        )

        EtiquetaSeccion("5. size fijo vs fillMaxWidth")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(Modifier.size(60.dp).background(Color(0xFFBBDEFB)),
                contentAlignment = Alignment.Center) { Text("60dp") }
            Box(Modifier.weight(1f).height(60.dp).background(Color(0xFFB3E5FC)),
                contentAlignment = Alignment.Center) { Text("Restante") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun S05_mpPreview() {
    MaterialTheme { S05Modifier_mpScreen() }
}
