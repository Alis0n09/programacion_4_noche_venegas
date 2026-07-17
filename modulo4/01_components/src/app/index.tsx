// app/index.tsx
import { StyleSheet, Text, View } from 'react-native'
import { Card } from './components/Card'
import { FilaInfo } from './components/FilaInfo'
import { TarjetaServidor } from './components/TarjetaServidor'

// ┌──────────────────────────────────────────────────────────────────┐
// │  Cambia este número y guarda (Ctrl+S) para navegar entre pasos. │
// │  1  Paso 1  Props tipadas — TarjetaServidor                     │
// │  2  Paso 2  children y composición — Card reutilizable          │
// │  3  Paso 3  Props opcionales y BadgeEstado                      │
// │  4  Paso 4  ScrollView y SafeAreaView                           │
// │  5  Paso 5  Modal de confirmación                               │
// │  6  Paso 6  Pantalla completa — detalle de servidor             │
// └──────────────────────────────────────────────────────────────────┘
const PASO = 2

export default function Index() {
  switch (PASO) {
    case 1:
      return <Paso1 />
    case 2:
      return <Paso2 />
    default:
      return (
        <View style={styles.centrado}>
          <Text>Paso {PASO}: crea el componente primero</Text>
        </View>
      )
  }
}

// ─── Paso 1 — Props tipadas ──────────────────────────────────────────


function Paso1() {
  return (
    <View style={styles.fondo}>
      <Text style={styles.encabezado}>Inventario de servidores</Text>
      <TarjetaServidor
        nombre="web-01"
        ip="10.0.2.10"
        sistema="Ubuntu 24.04 LTS"
        puerto={22}
      />
      <TarjetaServidor
        nombre="db-primary"
        ip="10.0.2.20"
        sistema="Debian 12"
        puerto={5432}
      />
      <TarjetaServidor
        nombre="cache-01"
        ip="10.0.2.30"
        sistema="Alpine 3.19"
        puerto={6379}
      />
      <TarjetaServidor
        nombre="react-app-01"
        ip="10.0.2.31"
        sistema="React 19"
        puerto={6379}
      />
    </View>
  )
}

function Paso2() {
  return (
    <View style={styles.fondo}>
      <Text style={styles.titulo}>Detalle de nodo</Text>

      <Card titulo="web-01" subtitulo="Servidor web principal">
        <FilaInfo etiqueta="IP" valor="10.0.2.10" />
        <FilaInfo etiqueta="Puerto" valor="22 (SSH)" />
        <FilaInfo etiqueta="OS" valor="Ubuntu 24.04 LTS" />
        <FilaInfo etiqueta="CPU" valor="4 vCPU · 48%" />
        <FilaInfo etiqueta="RAM" valor="8 GB · 3.1 GB usados" />
      </Card>

      <Card titulo="Conexiones activas">
        <FilaInfo etiqueta="HTTP" valor="142 req/s" />
        <FilaInfo etiqueta="SSH" valor="2 sesiones" />
        <FilaInfo etiqueta="Último acceso" valor="hace 3 minutos" />
      </Card>

      <Card titulo="Disco">
        <FilaInfo etiqueta="HTTP" valor="142 req/s" />
        <FilaInfo etiqueta="SSH" valor="2 sesiones" />
        <FilaInfo etiqueta="Último acceso" valor="hace 3 minutos" />
      </Card>
    </View>
  )
}

const styles = StyleSheet.create({
  fondo: {
    flex: 1,
    backgroundColor: '#f0f4f8',
    padding: 20,
    paddingTop: 60,
    gap: 12,
  },
  centrado: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  encabezado: {
    fontSize: 20,
    fontWeight: '700',
    color: '#1a237e',
    marginBottom: 4,
  },
  titulo: {
    fontSize: 20,
    fontWeight: '700',
    color: '#1a237e',
  },
  
})