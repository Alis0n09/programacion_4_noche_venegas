// lib/screens/pantalla_empleados_mp.dart
import 'package:flutter/material.dart';
import '../widgets/tarjeta_empleado_grid_mp.dart';
import '../models/empleado_nomina_mp.dart';
import '../widgets/fila_empleado_mp.dart';

class PantallaEmpleados extends StatefulWidget {
  const PantallaEmpleados({super.key});
  @override
  State<PantallaEmpleados> createState() => _PantallaEmpleadosState();
}

class _PantallaEmpleadosState extends State<PantallaEmpleados> {
  final _empleados = [
    EmpleadoNomina(id:'1', nombre:'Gabriela Calderón', codigoNomina:'012.003.001.001', numeroEmpleado:22,   cargo:'Vendedora',   departamento:'Ventas',            afiliadoIess:true,  prioritario:true),
    EmpleadoNomina(id:'2', nombre:'Jorge Vera',        codigoNomina:'012.003.002.002', numeroEmpleado:22,   cargo:'Bodeguero',   departamento:'Bodega',            afiliadoIess:true),
    EmpleadoNomina(id:'3', nombre:'Mateo Alba',        codigoNomina:'012.004.001.003', numeroEmpleado:2222, cargo:'Contador',    departamento:'Contabilidad',      afiliadoIess:false),
    EmpleadoNomina(id:'4', nombre:'Ana Chiluisa',      codigoNomina:'192.168.001.005', numeroEmpleado:22,   cargo:'Practicante', departamento:'Recursos Humanos',  afiliadoIess:false),
  ];

  bool _modoGrid = false;   // false = lista, true = cuadrícula

  void _togglePrioritario(int i) =>
      setState(() => _empleados[i].prioritario = !_empleados[i].prioritario);

  void _eliminar(int i) => setState(() => _empleados.removeAt(i));

  @override
  Widget build(BuildContext context) {
    final cs = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title:           Text('Empleados (${_empleados.length})'),
        backgroundColor: cs.primaryContainer,
        foregroundColor: cs.onPrimaryContainer,
        actions: [
          // Toggle lista / cuadrícula
          IconButton(
            icon:    Icon(_modoGrid ? Icons.list : Icons.grid_view),
            onPressed: () => setState(() => _modoGrid = !_modoGrid),
            tooltip: _modoGrid ? 'Vista lista' : 'Vista cuadrícula',
          ),
        ],
      ),
      body: _modoGrid
          ? GridView.builder(
              padding: const EdgeInsets.all(12),
              gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount:   2,
                childAspectRatio: 1.1,
                crossAxisSpacing: 8,
                mainAxisSpacing:  8,
              ),
              itemCount:   _empleados.length,
              itemBuilder: (ctx, i) => TarjetaEmpleadoGrid(
                empleado:      _empleados[i],
                onPrioritario: () => _togglePrioritario(i),
                onEliminar:    () => _eliminar(i),
              ),
            )
          : ListView.separated(
              itemCount:        _empleados.length,
              separatorBuilder: (_, __) =>
                  const Divider(height: 1, indent: 72),
              itemBuilder: (ctx, i) => FilaEmpleado(
                empleado:      _empleados[i],
                onPrioritario: () => _togglePrioritario(i),
                onEliminar:    () => _eliminar(i),
              ),
            ),
    );
  }
}
