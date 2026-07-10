// app/index.tsx — agrega al archivo existente

// ─── Paso 3 — Props opcionales ───────────────────────────────────────

type EstadoServidor = 'activo' | 'degradado' | 'inactivo' | 'error'

interface BadgeEstadoProps {
  estado: EstadoServidor
  tamaño?: number          // opcional — valor por defecto: 12
  mostrarIcono?: boolean   // opcional — valor por defecto: false
}

const COLOR_ESTADO: Record<EstadoServidor, { fondo: string; texto: string }> = {
  activo:    { fondo: '#e8f5e9', texto: '#2e7d32' },
  degradado: { fondo: '#fff8e1', texto: '#f57f17' },
  inactivo:  { fondo: '#f5f5f5', texto: '#616161' },
  error:     { fondo: '#fce4ec', texto: '#c62828' },
}

const ICONO_ESTADO: Record<EstadoServidor, string> = {
  activo:    '●',
  degradado: '◐',
  inactivo:  '○',
  error:     '✕',
}

function BadgeEstado({
  estado,
  tamaño = 12,
  mostrarIcono = false,
}: BadgeEstadoProps) {
  const colores = COLOR_ESTADO[estado]
  return (
    <View style={[estilos3.badge, { backgroundColor: colores.fondo }]}>
      {mostrarIcono && (
        <Text style={[estilos3.icono, { color: colores.texto, fontSize: tamaño }]}>
          {ICONO_ESTADO[estado]}{' '}
        </Text>
      )}
      <Text style={[estilos3.textoBadge, { color: colores.texto, fontSize: tamaño }]}>
        {estado.toUpperCase()}
      </Text>
    </View>
  )
}

interface FilaServidorProps {
  nombre: string
  ip: string
  estado: EstadoServidor
  latencia?: number        // ms — opcional
}

function FilaServidor({ nombre, ip, estado, latencia }: FilaServidorProps) {
  return (
    <View style={estilos3.fila}>
      <View style={estilos3.infoIzq}>
        <Text style={estilos3.nombreServidor}>{nombre}</Text>
        <Text style={estilos3.ipTexto}>{ip}</Text>
      </View>
      <View style={estilos3.infoDer}>
        {latencia !== undefined && (
          <Text style={estilos3.latencia}>{latencia} ms</Text>
        )}
        <BadgeEstado estado={estado} mostrarIcono tamaño={11} />
      </View>
    </View>
  )
}

function Paso3() {
  return (
    <View style={estilos3.fondo}>
      <Text style={estilos3.titulo}>Estado de la red</Text>
      <FilaServidor nombre="web-01"      ip="10.0.2.10" estado="activo"    latencia={8}   />
      <FilaServidor nombre="db-primary"  ip="10.0.2.20" estado="activo"    latencia={2}   />
      <FilaServidor nombre="cache-01"    ip="10.0.2.30" estado="degradado" latencia={340} />
      <FilaServidor nombre="worker-03"   ip="10.0.2.41" estado="error"                    />
      <FilaServidor nombre="backup-01"   ip="10.0.2.50" estado="inactivo"                 />
    </View>
  )
}

const estilos3 = StyleSheet.create({
  fondo: {
    flex: 1,
    backgroundColor: '#f0f4f8',
    padding: 20,
    paddingTop: 60,
    gap: 8,
  },
  titulo: {
    fontSize: 20,
    fontWeight: '700',
    color: '#1a237e',
    marginBottom: 8,
  },
  fila: {
    backgroundColor: '#ffffff',
    borderRadius: 10,
    paddingHorizontal: 16,
    paddingVertical: 14,
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    shadowColor: '#000',
    shadowOpacity: 0.05,
    shadowRadius: 3,
    shadowOffset: { width: 0, height: 1 },
    elevation: 1,
  },
  infoIzq: { gap: 2 },
  infoDer: { alignItems: 'flex-end', gap: 4 },
  nombreServidor: { fontSize: 14, fontWeight: '600', color: '#1a1a1a' },
  ipTexto: { fontSize: 12, color: '#90a4ae', fontFamily: 'monospace' },
  latencia: { fontSize: 11, color: '#546e7a' },
  badge: {
    flexDirection: 'row',
    alignItems: 'center',
    borderRadius: 4,
    paddingHorizontal: 6,
    paddingVertical: 2,
  },
  icono: { fontWeight: '700' },
  textoBadge: { fontWeight: '600' },
})