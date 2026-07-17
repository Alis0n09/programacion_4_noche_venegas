// lib/screens/pantalla_busqueda_mp.dart
import 'package:flutter/material.dart';
import '../widgets/tarjeta_empleado_grid_mp.dart';
import '../models/empleado_nomina_mp.dart';
import '../widgets/fila_empleado_mp.dart';

class PantallaBusqueda extends StatefulWidget {
  const PantallaBusqueda({super.key});
  @override
  State<PantallaBusqueda> createState() => _PantallaBusquedaState();
}

class _PantallaBusquedaState extends State<PantallaBusqueda> {
  final _empleados = [
    EmpleadoNomina(id:'1', nombre:'Gabriela Calderón', codigoNomina:'012.003.001.001', numeroEmpleado:22,   cargo:'Vendedora',   departamento:'Ventas',            afiliadoIess:true,  prioritario:true),
    EmpleadoNomina(id:'2', nombre:'Jorge Vera',        codigoNomina:'012.003.002.002', numeroEmpleado:22,   cargo:'Bodeguero',   departamento:'Bodega',            afiliadoIess:true),
    EmpleadoNomina(id:'3', nombre:'Mateo Alba',        codigoNomina:'012.004.001.003', numeroEmpleado:2222, cargo:'Contador',    departamento:'Contabilidad',      afiliadoIess:false),
    EmpleadoNomina(id:'4', nombre:'Ana Chiluisa',      codigoNomina:'192.168.001.005', numeroEmpleado:22,   cargo:'Practicante', departamento:'Recursos Humanos',  afiliadoIess:false),
  ];

  String _busqueda = '';     // texto actual de la búsqueda
  bool   _modoGrid = false;

  // Getter calculado — filtra sin modificar _empleados
  List<EmpleadoNomina> get _filtrados => _empleados
      .where((e) =>
          e.nombre.toLowerCase().contains(_busqueda.toLowerCase()) ||
          e.codigoNomina.contains(_busqueda) ||
          e.cargo.toLowerCase().contains(_busqueda.toLowerCase()))
      .toList();

  void _togglePrioritario(EmpleadoNomina e) =>
      setState(() => e.prioritario = !e.prioritario);

  void _eliminar(EmpleadoNomina e) =>
      setState(() => _empleados.removeWhere((x) => x.id == e.id));

  @override
  Widget build(BuildContext context) {
    final cs       = Theme.of(context).colorScheme;
    final filtrados = _filtrados;   // evalúa el getter una sola vez

    return Scaffold(
      appBar: AppBar(
        title:           Text('Empleados (${_empleados.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
        actions: [
          IconButton(
            icon:      Icon(_modoGrid ? Icons.list : Icons.grid_view),
            onPressed: () => setState(() => _modoGrid = !_modoGrid),
            tooltip:   _modoGrid ? 'Vista lista' : 'Vista cuadrícula',
          ),
        ],
      ),
      body: Column(
        children: [
          // ── SearchBar ─────────────────────────────────────────────
          Padding(
            padding: const EdgeInsets.fromLTRB(16, 12, 16, 8),
            child: SearchBar(
              hintText: 'Buscar por nombre, código o cargo...',
              leading:  const Icon(Icons.search),
              trailing: _busqueda.isNotEmpty
                  ? [
                      IconButton(
                        icon:      const Icon(Icons.clear),
                        onPressed: () => setState(() => _busqueda = ''),
                      ),
                    ]
                  : null,
              onChanged: (v) => setState(() => _busqueda = v),
              padding: const WidgetStatePropertyAll(
                EdgeInsets.symmetric(horizontal: 16),
              ),
            ),
          ),

          // ── Contador de resultados ────────────────────────────────
          if (_busqueda.isNotEmpty)
            Padding(
              padding: const EdgeInsets.only(left: 16, bottom: 4),
              child: Align(
                alignment: Alignment.centerLeft,
                child: Text(
                  '${filtrados.length} resultado${filtrados.length == 1 ? '' : 's'}',
                  style: Theme.of(context).textTheme.labelMedium?.copyWith(
                    color: cs.onSurfaceVariant,
                  ),
                ),
              ),
            ),

          // ── Lista o Grid ──────────────────────────────────────────
          Expanded(
            child: filtrados.isEmpty
                ? Center(
                    child: Column(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Icon(Icons.search_off,
                            size: 56, color: cs.onSurfaceVariant),
                        const SizedBox(height: 12),
                        Text(
                          'Sin resultados para "$_busqueda"',
                          style: TextStyle(color: cs.onSurfaceVariant),
                        ),
                        const SizedBox(height: 8),
                        TextButton(
                          onPressed: () => setState(() => _busqueda = ''),
                          child: const Text('Limpiar búsqueda'),
                        ),
                      ],
                    ),
                  )
                : _modoGrid
                    ? GridView.builder(
                        padding: const EdgeInsets.all(12),
                        gridDelegate:
                            const SliverGridDelegateWithFixedCrossAxisCount(
                          crossAxisCount:   2,
                          childAspectRatio: 1.1,
                          crossAxisSpacing: 8,
                          mainAxisSpacing:  8,
                        ),
                        itemCount:   filtrados.length,
                        itemBuilder: (ctx, i) => TarjetaEmpleadoGrid(
                          empleado:      filtrados[i],
                          onPrioritario: () => _togglePrioritario(filtrados[i]),
                          onEliminar:    () => _eliminar(filtrados[i]),
                        ),
                      )
                    : ListView.separated(
                        itemCount:        filtrados.length,
                        separatorBuilder: (_, __) =>
                            const Divider(height: 1, indent: 72),
                        itemBuilder: (ctx, i) => FilaEmpleado(
                          empleado:      filtrados[i],
                          onPrioritario: () => _togglePrioritario(filtrados[i]),
                          onEliminar:    () => _eliminar(filtrados[i]),
                        ),
                      ),
          ),
        ],
      ),
    );
  }
}
