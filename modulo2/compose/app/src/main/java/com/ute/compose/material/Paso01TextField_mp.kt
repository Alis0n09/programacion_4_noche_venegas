package com.ute.compose.material

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Paso01_TextField_mpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text("Registro de Empleado - Nómina Ecuador",
            style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()

        DemoBusquedaEmpleado()
        HorizontalDivider()
        FormularioRegistroEmpleado()
    }
}

@Composable
private fun DemoBusquedaEmpleado() {
    var busqueda by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Buscar empleado",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        OutlinedTextField(
            value = busqueda,
            onValueChange = { busqueda = it },
            placeholder = { Text("Buscar empleado por nombre o cédula...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            trailingIcon = {
                if (busqueda.isNotEmpty()) {
                    IconButton(onClick = { busqueda = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                    }
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = if (busqueda.isBlank()) "Escribe para buscar"
            else "Buscando: \"$busqueda\"",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun FormularioRegistroEmpleado() {
    var nombre by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var sueldo by remember { mutableStateOf("") }
    var departamento by remember { mutableStateOf("") }

    val nombreValido = nombre.trim().length >= 3
    val cedulaValido = cedula.length == 10 && cedula.all { it.isDigit() }
    val sueldoValido = sueldo.toDoubleOrNull() ?: 0.0 >= 460.0
    val deptoValido = departamento.trim().length >= 2

    val formularioValido = nombreValido && cedulaValido && sueldoValido && deptoValido

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Registrar nuevo empleado",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary)

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre completo") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            isError = nombre.isNotEmpty() && !nombreValido,
            supportingText = {
                when {
                    nombre.isNotEmpty() && !nombreValido ->
                        Text("Mínimo 3 caracteres", color = MaterialTheme.colorScheme.error)
                    nombreValido -> Text("✓ Válido", color = MaterialTheme.colorScheme.primary)
                    else -> Text("Requerido")
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cedula,
            onValueChange = { cedula = it },
            label = { Text("Cédula (10 dígitos)") },
            leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null) },
            isError = cedula.isNotEmpty() && !cedulaValido,
            supportingText = {
                if (cedula.isNotEmpty() && !cedulaValido)
                    Text("Debe tener 10 dígitos numéricos", color = MaterialTheme.colorScheme.error)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = sueldo,
            onValueChange = { sueldo = it },
            label = { Text("Sueldo base (\$)") },
            leadingIcon = { Icon(Icons.Default.AttachMoney, contentDescription = null) },
            isError = sueldo.isNotEmpty() && !sueldoValido,
            supportingText = {
                if (sueldo.isNotEmpty() && !sueldoValido)
                    Text("Mínimo \$460 (SBU)", color = MaterialTheme.colorScheme.error)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Next),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = departamento,
            onValueChange = { departamento = it },
            label = { Text("Departamento") },
            leadingIcon = { Icon(Icons.Default.Business, contentDescription = null) },
            isError = departamento.isNotEmpty() && !deptoValido,
            supportingText = {
                if (departamento.isNotEmpty() && !deptoValido)
                    Text("Mínimo 2 caracteres", color = MaterialTheme.colorScheme.error)
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { },
            enabled = formularioValido,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (formularioValido) "Registrar empleado ✓" else "Complete todos los campos")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso01_TextField_mpPreview() {
    MaterialTheme { Paso01_TextField_mpScreen() }
}
