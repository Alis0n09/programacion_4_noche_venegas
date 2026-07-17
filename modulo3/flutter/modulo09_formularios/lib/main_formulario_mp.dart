// lib/main_formulario_mp.dart
// Nota: en tu proyecto original este archivo (lib/main_formulario.dart)
// es una copia exacta de widgets/formulario_servidor.dart, con el
// mismo comentario de cabecera "lib/widgets/formulario_servidor.dart"
// y sin una función main() propia. Parece un archivo que quedó de un
// copy-paste. Lo replico igual (con el formulario de empleado) para
// que puedas revisarlo o borrarlo si no lo necesitas.
import 'package:flutter/material.dart';

class FormularioEmpleado extends StatefulWidget {
  final void Function(Map<String, String> datos) onGuardar;
  const FormularioEmpleado({super.key, required this.onGuardar});

  @override
  State<FormularioEmpleado> createState() => _FormularioEmpleadoState();
}

class _FormularioEmpleadoState extends State<FormularioEmpleado> {
  final _formKey  = GlobalKey<FormState>();

  final _ctrlNombre  = TextEditingController();
  final _ctrlCodigo  = TextEditingController();
  final _ctrlNumero  = TextEditingController(text: '1');
  final _ctrlCargo   = TextEditingController(text: 'Asistente');

  final _focusCodigo = FocusNode();
  final _focusNumero = FocusNode();
  final _focusCargo  = FocusNode();

  String _departamento = 'Ventas';
  bool   _afiliadoIess = true;

  static final _regexCodigo = RegExp(r'^(\d{1,3}\.){3}\d{1,3}$');

  @override
  void dispose() {
    _ctrlNombre.dispose();
    _ctrlCodigo.dispose();
    _ctrlNumero.dispose();
    _ctrlCargo.dispose();
    _focusCodigo.dispose();
    _focusNumero.dispose();
    _focusCargo.dispose();
    super.dispose();
  }

  void _guardar() {
    if (!_formKey.currentState!.validate()) return;

    widget.onGuardar({
      'nombre':      _ctrlNombre.text,
      'codigo':      _ctrlCodigo.text,
      'numero':      _ctrlNumero.text,
      'cargo':       _ctrlCargo.text,
      'departamento': _departamento,
      'iess':        _afiliadoIess.toString(),
    });
  }

  @override
  Widget build(BuildContext context) {
    return Form(
      key: _formKey,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          TextFormField(
            controller:      _ctrlNombre,
            decoration:      const InputDecoration(
              labelText:  'Nombre del empleado',
              hintText:   'Gabriela Calderón',
              prefixIcon: Icon(Icons.badge),
              border:     OutlineInputBorder(),
            ),
            textInputAction: TextInputAction.next,
            onFieldSubmitted: (_) => _focusCodigo.requestFocus(),
            validator: (v) {
              if (v == null || v.trim().isEmpty) return 'El nombre es obligatorio';
              if (v.length < 3)                  return 'Mínimo 3 caracteres';
              if (!RegExp(r'^[a-zA-ZÀ-ÿ\s\-]+$').hasMatch(v))
                return 'Solo letras, espacios y guiones';
              return null;
            },
          ),
          const SizedBox(height: 12),
          TextFormField(
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
            onFieldSubmitted: (_) => _focusNumero.requestFocus(),
            validator: (v) {
              if (v == null || v.isEmpty) return 'El código es obligatorio';
              if (!_regexCodigo.hasMatch(v))  return 'Formato inválido (ej. 012.003.001.045)';
              final partes = v.split('.').map(int.parse).toList();
              if (partes.any((o) => o > 255)) return 'Cada segmento debe ser 0–255';
              return null;
            },
          ),
          const SizedBox(height: 12),
          TextFormField(
            controller:      _ctrlNumero,
            focusNode:       _focusNumero,
            decoration:      const InputDecoration(
              labelText:  'Número de empleado',
              prefixIcon: Icon(Icons.tag),
              border:     OutlineInputBorder(),
            ),
            keyboardType:    TextInputType.number,
            textInputAction: TextInputAction.next,
            onFieldSubmitted: (_) => _focusCargo.requestFocus(),
            validator: (v) {
              final numero = int.tryParse(v ?? '');
              if (numero == null)               return 'Debe ser un número';
              if (numero < 1 || numero > 65535) return 'Número entre 1 y 65535';
              return null;
            },
          ),
          const SizedBox(height: 12),
          TextFormField(
            controller:      _ctrlCargo,
            focusNode:       _focusCargo,
            decoration:      const InputDecoration(
              labelText:  'Cargo',
              prefixIcon: Icon(Icons.work_outline),
              border:     OutlineInputBorder(),
            ),
            textInputAction: TextInputAction.next,
            validator: (v) =>
                v == null || v.trim().isEmpty ? 'El cargo es obligatorio' : null,
          ),
          const SizedBox(height: 12),
          DropdownButtonFormField<String>(
            value:      _departamento,
            decoration: const InputDecoration(
              labelText:  'Departamento',
              prefixIcon: Icon(Icons.apartment),
              border:     OutlineInputBorder(),
            ),
            items: [
              'Ventas', 'Bodega', 'Contabilidad',
              'Recursos Humanos', 'Gerencia',
            ].map((s) => DropdownMenuItem(value: s, child: Text(s))).toList(),
            onChanged: (v) => setState(() => _departamento = v!),
          ),
          const SizedBox(height: 8),
          SwitchListTile(
            title:     const Text('Afiliado al IESS'),
            subtitle:  const Text('Aportes registrados'),
            value:     _afiliadoIess,
            onChanged: (v) => setState(() => _afiliadoIess = v),
            secondary: const Icon(Icons.verified_user),
          ),
          const SizedBox(height: 16),
          Row(children: [
            Expanded(
              child: OutlinedButton(
                onPressed: () => _formKey.currentState?.reset(),
                child: const Text('Limpiar'),
              ),
            ),
            const SizedBox(width: 12),
            Expanded(
              flex: 2,
              child: FilledButton.icon(
                onPressed: _guardar,
                icon:  const Icon(Icons.save),
                label: const Text('Guardar empleado'),
              ),
            ),
          ]),
        ],
      ),
    );
  }
}
