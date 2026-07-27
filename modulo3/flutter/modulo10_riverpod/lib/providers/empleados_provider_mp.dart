// lib/providers/empleados_provider_mp.dart
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:flutter_riverpod/legacy.dart';
import '../models/empleado_nomina_mp.dart';

// NotifierProvider — estado complejo con métodos propios
class EmpleadosNotifier extends Notifier<List<EmpleadoNomina>> {
  @override
  List<EmpleadoNomina> build() => [
    EmpleadoNomina(id:'1', nombre:'Gabriela Calderón', codigoNomina:'012.003.001.001', numeroEmpleado:22,   afiliadoIess:true,  prioritario:true),
    EmpleadoNomina(id:'2', nombre:'Jorge Vera',        codigoNomina:'012.003.002.002', numeroEmpleado:22,   afiliadoIess:true),
    EmpleadoNomina(id:'3', nombre:'Mateo Alba',        codigoNomina:'012.004.001.003', numeroEmpleado:2222, afiliadoIess:false),
  ];

  void togglePrioritario(String id) {
    state = state.map((e) =>
        e.id == id
          ? EmpleadoNomina(id:e.id, nombre:e.nombre, codigoNomina:e.codigoNomina,
                        numeroEmpleado:e.numeroEmpleado, afiliadoIess:e.afiliadoIess,
                        prioritario:!e.prioritario)
          : e
    ).toList();
  }

  void eliminar(String id) {
    state = state.where((e) => e.id != id).toList();
  }

  void agregar(EmpleadoNomina empleado) {
    state = [...state, empleado];
  }
}

final empleadosProvider =
    NotifierProvider<EmpleadosNotifier, List<EmpleadoNomina>>(
  EmpleadosNotifier.new,
);

// Filtro de búsqueda — estado primitivo
final busquedaProvider = StateProvider<String>((ref) => '');

// Provider DERIVADO — se recalcula cuando cualquiera de sus dependencias cambia
final empleadosFiltradosProvider = Provider<List<EmpleadoNomina>>((ref) {
  final todos    = ref.watch(empleadosProvider);
  final busqueda = ref.watch(busquedaProvider);

  if (busqueda.isEmpty) return todos;

  final q = busqueda.toLowerCase();
  return todos.where((e) =>
      e.nombre.toLowerCase().contains(q) || e.codigoNomina.contains(q)
  ).toList();
  // Cuando 'empleadosProvider' o 'busquedaProvider' cambian,
  // este provider se recalcula automáticamente.
});
