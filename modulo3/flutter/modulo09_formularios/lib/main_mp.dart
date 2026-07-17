// lib/main_mp.dart
import 'package:flutter/material.dart';
import 'package:modulo09_formularios/models/empleado_nomina_mp.dart';
import 'package:modulo09_formularios/screens/pantalla_busqueda_mp.dart';
import 'package:modulo09_formularios/screens/pantalla_empleados_mp.dart';
import 'package:modulo09_formularios/widgets/fila_empleado_mp.dart';
import 'package:modulo09_formularios/widgets/formulario_empleado_mp.dart';

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  TextField + TextEditingController + FocusNode       │
// │  2  Paso 2  Form + TextFormField + validación                   │
// │  3  Paso 3  Modelo + ListView.builder + ListTile acciones       │
// │  4  Paso 4  GridView.builder + toggle lista/grid                │
// │  5  Paso 5  SearchBar + filtrado en tiempo real                 │
// └──────────────────────────────────────────────────────────────────┘
const int paso = 4;

void main() => runApp(MaterialApp(
  debugShowCheckedModeBanner: false,
  theme: ThemeData(
    colorScheme: ColorScheme.fromSeed(
      seedColor: const Color(0xFF1B5E20),
    ),
    useMaterial3: true,
  ),
  home: switch (paso) {
    1 => const _Paso1(),
    2 => const _Paso2 (),
    3 => const _Paso3(),
    4 => const PantallaEmpleados(),
    5 => const PantallaBusqueda(),
    _ => Scaffold(
        body: Center(child: Text('Paso $paso: crea el widget primero'))),
  },
));

// ─── Paso 1 — vive en main.dart ────────────────────────────────────────
class _Paso1 extends StatefulWidget {
  const _Paso1();
  @override
  State<_Paso1> createState() => _Paso1State();
}

class _Paso1State extends State<_Paso1> {
  final _ctrlNombre  = TextEditingController();
  final _ctrlCodigo  = TextEditingController();
  final _ctrlNumero  = TextEditingController(text: '1');
  final _ctrlCargo   = TextEditingController();
  final _focusCodigo = FocusNode();
  final _focusNumero = FocusNode();

  @override
  void dispose() {
    _ctrlNombre.dispose();
    _ctrlCodigo.dispose();
    _ctrlNumero.dispose();
    _ctrlCargo.dispose();
    _focusCodigo.dispose();
    _focusNumero.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Nuevo empleado'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller:      _ctrlNombre,
              decoration:      const InputDecoration(
                labelText:  'Nombre',
                hintText:   'Gabriela Calderón',
                prefixIcon: Icon(Icons.badge),
                border:     OutlineInputBorder(),
              ),
              textInputAction: TextInputAction.next,
              onSubmitted:     (_) => _focusCodigo.requestFocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller:      _ctrlCodigo,
              focusNode:       _focusCodigo,
              decoration:      const InputDecoration(
                labelText:  'Código de nómina',
                hintText:   '012.003.001.045',
                prefixIcon: Icon(Icons.qr_code),
                border:     OutlineInputBorder(),
              ),
              keyboardType:    TextInputType.number,
              textInputAction: TextInputAction.next,
              onSubmitted:     (_) => _focusNumero.requestFocus(),
            ),

            const SizedBox(height: 12),
            TextField(
              controller:      _ctrlCargo,

              decoration:      const InputDecoration(
                labelText:  'Cargo',
                hintText:   'Vendedora',
                prefixIcon: Icon(Icons.work_outline),
                border:     OutlineInputBorder(),
              ),
              keyboardType:    TextInputType.text,
              textInputAction: TextInputAction.next,
              onSubmitted:     (_) => _focusNumero.requestFocus(),
            ),
            const SizedBox(height: 12),
            TextField(
              controller:  _ctrlNumero,
              focusNode:   _focusNumero,
              decoration:  const InputDecoration(
                labelText:  'Número de empleado',
                prefixIcon: Icon(Icons.tag),
                border:     OutlineInputBorder(),
              ),
              keyboardType:    TextInputType.number,
              textInputAction: TextInputAction.done,
              onSubmitted:     (_) => FocusScope.of(context).unfocus(),
            ),
            const SizedBox(height: 20),
            FilledButton.icon(
              onPressed: () {
                FocusScope.of(context).unfocus();
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text(
                      'Registrando a ${_ctrlNombre.text} '
                      '(${_ctrlCodigo.text} · #${_ctrlNumero.text})',
                    ),
                    behavior: SnackBarBehavior.floating,
                  ),
                );
              },
              icon:  const Icon(Icons.save),
              label: const Text('Registrar'),
            ),
            const SizedBox(height: 8),
            OutlinedButton(
              onPressed: () {
                _ctrlNombre.clear();
                _ctrlCodigo.clear();
                _ctrlNumero.text = '1';
                _ctrlCargo.clear();
              },
              child: const Text('Limpiar campos'),
            ),
          ],
        ),
      ),
    );
  }
}

class _Paso2 extends StatelessWidget {
  const _Paso2();

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           const Text('Nuevo empleado'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: FormularioEmpleado(
          onGuardar: (datos) {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(
                content: Text(
                    'Guardado: ${datos['nombre']} — ${datos['cargo']}'),
                behavior: SnackBarBehavior.floating,
              ),
            );
          },
        ),
      ),
    );
  }
}

class _Paso3 extends StatefulWidget {
  const _Paso3();
  @override
  State<_Paso3> createState() => _Paso3State();
}

class _Paso3State extends State<_Paso3> {
  final _empleados = [
    EmpleadoNomina(id:'1', nombre:'Gabriela Calderón', codigoNomina:'012.003.001.001', numeroEmpleado:22,   cargo:'Vendedora',   departamento:'Ventas',            afiliadoIess:true,  prioritario:true),
    EmpleadoNomina(id:'2', nombre:'Jorge Vera',        codigoNomina:'012.003.002.002', numeroEmpleado:22,   cargo:'Bodeguero',   departamento:'Bodega',            afiliadoIess:true),
    EmpleadoNomina(id:'3', nombre:'Mateo Alba',        codigoNomina:'012.004.001.003', numeroEmpleado:2222, cargo:'Contador',    departamento:'Contabilidad',      afiliadoIess:false),
    EmpleadoNomina(id:'4', nombre:'Ana Chiluisa',      codigoNomina:'192.168.001.005', numeroEmpleado:22,   cargo:'Practicante', departamento:'Recursos Humanos',  afiliadoIess:false),
  ];

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Empleados (${_empleados.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
      ),
      body: _empleados.isEmpty
          ? Center(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Icon(Icons.badge_outlined, size: 56, color: cs.onSurfaceVariant),
                  const SizedBox(height: 12),
                  Text('Sin empleados',
                      style: TextStyle(color: cs.onSurfaceVariant)),
                ],
              ),
            )
          : ListView.separated(
              itemCount:        _empleados.length,
              separatorBuilder: (_, __) =>
                  const Divider(height: 1, indent: 72),
              itemBuilder: (ctx, i) => FilaEmpleado(
                empleado:      _empleados[i],
                onPrioritario: () => setState(() =>
                    _empleados[i].prioritario = !_empleados[i].prioritario),
                onEliminar: () => setState(() => _empleados.removeAt(i)),
              ),
            ),
    );
  }
}
