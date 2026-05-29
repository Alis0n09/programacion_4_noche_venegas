package com.ute.compose.material

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ute.compose.model.Empleado
import com.ute.compose.model.empleadosDeMuestra

data class DestinoNomina06(
    val ruta: String,
    val etiqueta: String,
    val iconoActivo: ImageVector,
    val iconoInactivo: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Paso06Dialogos_mpScreen() {
    var empleados by remember { mutableStateOf(empleadosDeMuestra) }
    var busqueda by remember { mutableStateOf("") }
    var filtro by remember { mutableStateOf("Todos") }
    var destinoActual by remember { mutableStateOf("empleados") }

    var mostrarNuevo by remember { mutableStateOf(false) }
    var empleadoAEliminar by remember { mutableStateOf<Empleado?>(null) }

    var mensajeSnack by remember { mutableStateOf<String?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(mensajeSnack) {
        mensajeSnack?.let {
            snackbarHostState.showSnackbar(it)
            mensajeSnack = null
        }
    }

    val empleadosFiltrados = empleados
        .filter { empleado ->
            when (filtro) {
                "Activos" -> empleado.activo
                "Sistemas" -> empleado.departamento == "Sistemas"
                "Contabilidad" -> empleado.departamento == "Contabilidad"
                "Ventas" -> empleado.departamento == "Ventas"
                else -> true
            }
        }
        .filter { empleado ->
            busqueda.isBlank() ||
                    empleado.nombre.contains(busqueda, ignoreCase = true) ||
                    empleado.cedula.contains(busqueda, ignoreCase = true) ||
                    empleado.departamento.contains(busqueda, ignoreCase = true)
        }

    val destinos = listOf(
        DestinoNomina06("empleados", "Empleados", Icons.Filled.People, Icons.Outlined.People),
        DestinoNomina06("nomina", "Nómina", Icons.Filled.Payments, Icons.Outlined.Payments),
        DestinoNomina06("resumen", "Resumen", Icons.Filled.Assessment, Icons.Outlined.Assessment)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Control de Nómina (${empleados.size})",
                        fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    IconButton(onClick = {
                        filtro = if (filtro == "Activos") "Todos" else "Activos"
                    }) {
                        Icon(
                            imageVector = if (filtro == "Activos")
                                Icons.Default.CheckCircle
                            else
                                Icons.Default.Groups,
                            contentDescription = "Filtrar activos",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        bottomBar = {
            NavigationBar {
                destinos.forEach { destino ->
                    val seleccionado = destinoActual == destino.ruta

                    NavigationBarItem(
                        selected = seleccionado,
                        onClick = { destinoActual = destino.ruta },
                        icon = {
                            Icon(
                                imageVector = if (seleccionado)
                                    destino.iconoActivo
                                else
                                    destino.iconoInactivo,
                                contentDescription = destino.etiqueta
                            )
                        },
                        label = { Text(destino.etiqueta) }
                    )
                }
            }
        },

        floatingActionButton = {
            if (destinoActual == "empleados") {
                FloatingActionButton(onClick = { mostrarNuevo = true }) {
                    Icon(Icons.Default.PersonAdd, contentDescription = "Nuevo empleado")
                }
            }
        },

        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }

    ) { paddingValues ->

        when (destinoActual) {
            "empleados" -> ContenidoEmpleados(
                empleados = empleadosFiltrados,
                busqueda = busqueda,
                filtro = filtro,
                onBusqueda = { busqueda = it },
                onFiltro = { filtro = it },
                onGenerarRol = { empleado ->
                    mensajeSnack = "💰 Rol de pago generado para ${empleado.nombre}"
                },
                onEliminar = { empleado ->
                    empleadoAEliminar = empleado
                },
                modifier = Modifier.padding(paddingValues)
            )

            "nomina" -> PantallaNominaContent(
                empleados = empleados,
                modifier = Modifier.padding(paddingValues)
            )

            "resumen" -> PantallaResumenNomina06Content(
                empleados = empleados,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }

    if (mostrarNuevo) {
        DialogNuevoEmpleado(
            onDismiss = { mostrarNuevo = false },
            onGuardar = { nuevoEmpleado ->
                empleados = empleados + nuevoEmpleado
                mostrarNuevo = false
                mensajeSnack = "✅ ${nuevoEmpleado.nombre} agregado a la nómina"
            }
        )
    }

    empleadoAEliminar?.let { empleado ->
        AlertDialog(
            onDismissRequest = { empleadoAEliminar = null },
            icon = {
                Icon(
                    Icons.Default.Warning,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            },
            title = { Text("Eliminar empleado") },
            text = {
                Text(
                    "¿Seguro que quieres eliminar a ${empleado.nombre} de la nómina? " +
                            "Esta acción no se puede deshacer."
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        empleados = empleados.filter { it.id != empleado.id }
                        mensajeSnack = "🗑 ${empleado.nombre} eliminado"
                        empleadoAEliminar = null
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { empleadoAEliminar = null }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Composable
private fun ContenidoEmpleados(
    empleados: List<Empleado>,
    busqueda: String,
    filtro: String,
    onBusqueda: (String) -> Unit,
    onFiltro: (String) -> Unit,
    onGenerarRol: (Empleado) -> Unit,
    onEliminar: (Empleado) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        OutlinedTextField(
            value = busqueda,
            onValueChange = onBusqueda,
            placeholder = { Text("Buscar empleado, cédula o departamento...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            trailingIcon = {
                if (busqueda.isNotEmpty()) {
                    IconButton(onClick = { onBusqueda("") }) {
                        Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                    }
                }
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(listOf("Todos", "Activos", "Sistemas", "Contabilidad", "Ventas")) { opcion ->
                FilterChip(
                    selected = filtro == opcion,
                    onClick = { onFiltro(opcion) },
                    label = { Text(opcion) },
                    leadingIcon = if (filtro == opcion) {{
                        Icon(
                            Icons.Default.Check,
                            contentDescription = null,
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }} else null
                )
            }
        }

        Spacer(Modifier.height(4.dp))

        if (empleados.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Default.SearchOff,
                        contentDescription = null,
                        modifier = Modifier.size(56.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Sin empleados encontrados",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        "${empleados.size} empleado(s)",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }

                items(empleados, key = { it.id }) { empleado ->
                    TarjetaEmpleadoCompleta(
                        empleado = empleado,
                        onGenerarRol = { onGenerarRol(empleado) },
                        onEliminar = { onEliminar(empleado) }
                    )
                }

                item {
                    Spacer(Modifier.height(100.dp))
                }
            }
        }
    }
}

@Composable
private fun TarjetaEmpleadoCompleta(
    empleado: Empleado,
    onGenerarRol: () -> Unit,
    onEliminar: () -> Unit
) {
    val aporteIess = empleado.sueldo * 0.0945
    val sueldoNeto = empleado.sueldo - aporteIess

    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
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
                    empleado.nombre.first().uppercase(),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(Modifier.weight(1f)) {
                Text(
                    empleado.nombre,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    "Cédula: ${empleado.cedula}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    "Departamento: ${empleado.departamento}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    "Sueldo: $${empleado.sueldo}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    "Neto aprox: $${"%.2f".format(sueldoNeto)}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(onClick = onGenerarRol) {
                Icon(
                    Icons.Default.Payments,
                    contentDescription = "Generar rol",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(onClick = onEliminar) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Eliminar empleado",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
private fun PantallaNominaContent(
    empleados: List<Empleado>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                "Roles de pago",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Text(
                "Cálculo referencial con aporte personal IESS del 9.45%",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        items(empleados, key = { it.id }) { empleado ->
            val aporteIess = empleado.sueldo * 0.0945
            val sueldoNeto = empleado.sueldo - aporteIess

            ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        empleado.nombre,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Text("Sueldo bruto: $${empleado.sueldo}")
                    Text("Aporte IESS 9.45%: $${"%.2f".format(aporteIess)}")
                    Text(
                        "Sueldo neto aproximado: $${"%.2f".format(sueldoNeto)}",
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
private fun PantallaResumenNomina06Content(
    empleados: List<Empleado>,
    modifier: Modifier = Modifier
) {
    val totalSueldos = empleados.sumOf { it.sueldo }
    val totalIess = totalSueldos * 0.0945
    val totalNeto = totalSueldos - totalIess
    val empleadosActivos = empleados.count { it.activo }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    Icons.Default.Assessment,
                    contentDescription = null,
                    modifier = Modifier.size(72.dp),
                    tint = MaterialTheme.colorScheme.primary
                )

                Text(
                    "Resumen de Nómina Ecuador",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                HorizontalDivider()

                Text("Total empleados: ${empleados.size}")
                Text("Empleados activos: $empleadosActivos")
                Text("Total sueldos: $${"%.2f".format(totalSueldos)}")
                Text("Total IESS 9.45%: $${"%.2f".format(totalIess)}")

                Text(
                    "Total neto aproximado: $${"%.2f".format(totalNeto)}",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    "Incluye conceptos como sueldo, aporte IESS, décimos y beneficios de ley.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun DialogNuevoEmpleado(
    onDismiss: () -> Unit,
    onGuardar: (Empleado) -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var sueldo by remember { mutableStateOf("") }
    var departamento by remember { mutableStateOf("") }

    val nombreValido = nombre.trim().length >= 2
    val cedulaValida = cedula.trim().length == 10
    val sueldoValido = sueldo.toDoubleOrNull() != null && sueldo.toDouble() > 0
    val departamentoValido = departamento.trim().length >= 2
    val valido = nombreValido && cedulaValida && sueldoValido && departamentoValido

    Dialog(onDismissRequest = onDismiss) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    "Nuevo empleado",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre completo") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    isError = nombre.isNotEmpty() && !nombreValido,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
                )

                OutlinedTextField(
                    value = cedula,
                    onValueChange = { cedula = it },
                    label = { Text("Cédula") },
                    leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null) },
                    isError = cedula.isNotEmpty() && !cedulaValida,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    )
                )

                OutlinedTextField(
                    value = sueldo,
                    onValueChange = { sueldo = it },
                    label = { Text("Sueldo") },
                    leadingIcon = { Icon(Icons.Default.AttachMoney, contentDescription = null) },
                    isError = sueldo.isNotEmpty() && !sueldoValido,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Next
                    )
                )

                OutlinedTextField(
                    value = departamento,
                    onValueChange = { departamento = it },
                    label = { Text("Departamento") },
                    leadingIcon = { Icon(Icons.Default.Business, contentDescription = null) },
                    isError = departamento.isNotEmpty() && !departamentoValido,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancelar")
                    }

                    Spacer(Modifier.width(8.dp))

                    Button(
                        onClick = {
                            onGuardar(
                                Empleado(
                                    id = System.currentTimeMillis().toInt(),
                                    nombre = nombre.trim(),
                                    cedula = cedula.trim(),
                                    sueldo = sueldo.toDouble(),
                                    departamento = departamento.trim(),
                                    activo = true
                                )
                            )
                        },
                        enabled = valido
                    ) {
                        Text("Guardar")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Paso06mpPreview() {
    MaterialTheme {
        Paso06Dialogos_mpScreen()
    }
}