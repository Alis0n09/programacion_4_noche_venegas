package com.ute.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Paso01Suma_mpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Calculo de Sueldo Neto - Nomina",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        CalcularSueldoNeto()
    }
}

@Composable
private fun CalcularSueldoNeto() {
    var sueldoBase by remember { mutableStateOf("460") }
    var horasExtras by remember { mutableStateOf("0") }
    var resultado by remember { mutableStateOf("460.00") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Calculo de Nomina",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        OutlinedTextField(
            value = sueldoBase,
            onValueChange = { sueldoBase = it },
            label = { Text("Sueldo Base (\$)") },
            leadingIcon = { Icon(Icons.Default.AttachMoney, contentDescription = null) },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = horasExtras,
            onValueChange = { horasExtras = it },
            label = { Text("Horas Extras") },
            leadingIcon = { Icon(Icons.Default.Timer, contentDescription = null) },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val base = sueldoBase.toDoubleOrNull() ?: 0.0
                val extras = horasExtras.toDoubleOrNull() ?: 0.0
                val bruto = base + (extras * 4.50)
                val descuento = bruto * 0.0945
                val neto = bruto - descuento
                resultado = "%.2f".format(neto)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Sueldo Neto")
        }
        Text("Sueldo neto (con desc. IESS 9.45%): \$$resultado")
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01Suma_mpPreview() {
    MaterialTheme { Paso01Suma_mpScreen() }
}
