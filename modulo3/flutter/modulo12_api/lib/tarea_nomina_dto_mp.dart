// lib/tarea_nomina_dto_mp.dart
// Reutiliza la API pública de JSONPlaceholder (/todos) — no existe una API
// pública de nómina equivalente, así que reinterpretamos cada "todo" como
// una tarea pendiente del departamento de RRHH/Nómina.
class TareaNominaDto {
  final int id;
  final String titulo;      // antes 'title'
  final bool completada;    // antes 'completed'

  const TareaNominaDto({
    required this.id,
    required this.titulo,
    required this.completada,
  });

  factory TareaNominaDto.fromJson(Map<String, dynamic> json) => TareaNominaDto(
    id:         json['id']        as int,
    titulo:     json['title']     as String,
    completada: json['completed'] as bool,
  );
}
