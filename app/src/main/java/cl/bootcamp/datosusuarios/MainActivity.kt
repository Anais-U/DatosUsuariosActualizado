package cl.bootcamp.datosusuarios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.datosusuarios.ui.theme.DatosUsuariosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DatosUsuariosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding), contentAlignment = Alignment.Center) {
                        // Llamar a la función MostrarDatosUsuarios, que mostrará los datos de los usuarios
                        MostrarDatosUsuarios(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}
// Composable para mostrar los datos de los usuarios
@Composable
fun MostrarDatosUsuarios(modifier: Modifier = Modifier) {
    // Crear dos usuarios
    val usuario1 = Usuario(nombre = "Rick Grimes", edad = 45, trabajo = "Sheriff", referencia = null)
    val usuario2 = Usuario(nombre = "Walter White", edad = 60, trabajo = "Profesor de química", referencia = usuario1)

    // Mostrar los datos de los usuarios
    val datosUsuarios = usuario1.mostrarDatos() + "\n\n" + usuario2.mostrarDatos()

    // Mostrar en la pantalla usando un Text composable
    Text(
        text = datosUsuarios,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMostrarDatosUsuarios() {
    DatosUsuariosTheme {
        MostrarDatosUsuarios()
    }
}
