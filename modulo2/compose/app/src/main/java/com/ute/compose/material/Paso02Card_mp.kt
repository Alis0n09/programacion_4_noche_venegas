package com.ute.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ute.compose.model.Empleado
import com.ute.compose.model.empleadosDeMuestra

@Composable
fun TarjetaEmpleado(
    empleado: Empleado,
    onClick: () -> Unit = {},
    onPagar: () -> Unit = {},
    onDetalle: () -> Unit = {}
) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = empleado.nombre.first().uppercase(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = empleado.nombre,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = empleado.departamento,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(4.dp))
                AssistChip(
                    onClick = {},
                    label = { Text("Sueldo: \$${empleado.sueldo}",
                        style = MaterialTheme.typography.labelSmall) }
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = onPagar) {
                    Icon(
                        imageVector = Icons.Default.Payments,
                        contentDescription = "Pagar",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = onDetalle) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Detalle",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun Paso02Card_mpScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Empleados Registrados - Nómina Ecuador",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        empleadosDeMuestra.forEach { empleado ->
            TarjetaEmpleado(
                empleado = empleado,
                onClick = { },
                onPagar = { },
                onDetalle = { }
            )
        }

        HorizontalDivider()
        Text("Tipos de Contrato",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary)

        Card(modifier = Modifier.fillMaxWidth()) {
            Text("FIJO - 1 año renovable", Modifier.padding(16.dp))
        }

        ElevatedCard(modifier = Modifier.fillMaxWidth()) {
            Text("INDEFINIDO - Estabilidad completa", Modifier.padding(16.dp))
        }

        OutlinedCard(modifier = Modifier.fillMaxWidth()) {
            Text("TEMPORAL - Máx 6 meses", Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso02_mpPreview() {
    MaterialTheme { Paso02Card_mpScreen() }
}
