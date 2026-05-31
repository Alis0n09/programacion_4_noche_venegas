// MainActivity.kt
package com.ute.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.ute.compose.screens.*
import com.ute.compose.material.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // ◀ CAMBIA AQUÍ para probar cada sección:
                // S01Saludo_mpScreen()
                // S02Text_mpScreen()
                // S03Button_mpScreen()
                // S04Layout_mpScreen()
                // S05Modifier_mpScreen()
                // S06Estado_mpScreen()
                // S07StateHoisting_mpScreen()
                // S08Bienvenida_mpScreen()

                // Componentes Material 3: TextField, Card, LazyColumn, Scaffold y diálogos
                // ◀ CAMBIA AQUÍ para probar cada paso:
                 // Paso01Suma_mpScreen()
                // Paso01_TextField_mpScreen()
                 // Paso02Card_mpScreen()
                //Paso03LazyColumn_mpScreen()
                  //Paso04Scaffold_mpScreen()
                // Paso05NavBar_mpScreen()
                Paso06Dialogos_mpScreen()   // ← paso activo
            }
        }
    }
}