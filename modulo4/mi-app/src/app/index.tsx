import { StyleSheet, Text, View } from 'react-native';
import Paso1 from './Paso1';
import Paso2 from './Paso2';
import Paso3 from './Paso3';

const PASO = 2;

export default function Index() {
  switch (PASO) {
    case 1:
      return <Paso1 />;
    case 2:
      return <Paso2 />;
    case 3:
      return <Paso3 />;
    default:
      return (
        <View style={styles.contenedor}>
          <Text>Paso {PASO}: crea la pantalla primero</Text>
        </View>
      );
  }
}

const styles = StyleSheet.create({
  contenedor: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});