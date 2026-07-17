// lib/concepto_nomina_dto_mp.dart
// Reutiliza la API pública de Platzi (api.escuelajs.co/api/v1/products) —
// reinterpretamos cada "producto" como un concepto de nómina (ingreso,
// egreso o aporte) con su monto y tipo.
import 'concepto_nomina_mp.dart';

class ConceptoNominaDto {
  final int     id;
  final String  title;
  final int     price;
  final bool    isActive;
  final String? categoryName;

  const ConceptoNominaDto({
    required this.id,
    required this.title,
    required this.price,
    required this.isActive,
    this.categoryName,
  });

  factory ConceptoNominaDto.fromJson(Map<String, dynamic> json) => ConceptoNominaDto(
    id:           json['id']            as int,
    title:         json['title']          as String? ?? 'Concepto',
    price:        json['price']         as int? ?? 0,
    isActive:     json['is_active']     as bool? ?? false,
    categoryName: json['category']['name'] as String? ?? 'Sin tipo',
  );

  ConceptoNomina toDomain() => ConceptoNomina(
    id:     id,
    nombre: title,
    monto:  price.toDouble(),
    activo: isActive,
    tipo:   categoryName,
  );
}
