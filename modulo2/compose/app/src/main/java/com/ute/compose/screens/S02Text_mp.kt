package com.ute.compose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun S02Text_mpScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Información de Nomina - Estilos de Texto",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        EtiquetaSeccion("1. Datos basicos")
        Text("Sueldo Basico Unificado 2024: \$460")

        EtiquetaSeccion("2. fontSize + fontWeight + fontStyle")
        Text("SISTEMA DE NOMINA", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Reporte mensual", fontSize = 18.sp, fontStyle = FontStyle.Italic)
        Text("Valores", fontSize = 20.sp, fontWeight = FontWeight.Light)

        EtiquetaSeccion("3. Color")
        Text("Totales en azul",
            color = Color(0xFF1976D2))
        Text("Total a pagar subrayado",
            textDecoration = TextDecoration.Underline)
        Text("Descuentos aplicados",
            textDecoration = TextDecoration.LineThrough,
            color = MaterialTheme.colorScheme.onSurfaceVariant)

        EtiquetaSeccion("4. maxLines + TextOverflow")
        Text(
            text = "El empleado registra un total de 160 horas laboradas",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Los descuentos aplicados incluyen aporte IESS 9.45%",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        EtiquetaSeccion("5. Escala tipográfica")
        Text("Nomina", style = MaterialTheme.typography.headlineMedium)
        Text("Reporte Mensual", style = MaterialTheme.typography.titleLarge)
        Text("Total empleados: 8", style = MaterialTheme.typography.bodyLarge)
        Text("Período: Enero 2024", style = MaterialTheme.typography.bodySmall)
        Text("Pendientes", style = MaterialTheme.typography.labelSmall)

        EtiquetaSeccion("6. TextAlign")
        Text(
            text = "SISTEMA DE NOMINA",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Total procesado: \$8,500.00",
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun S02_mpPreview() {
    MaterialTheme { S02Text_mpScreen() }
}
