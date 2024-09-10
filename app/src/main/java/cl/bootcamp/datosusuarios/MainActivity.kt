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
import androidx.compose.ui.unit.dp // Importar unidad de medida dp
import cl.bootcamp.datosusuarios.ui.theme.DatosUsuariosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DatosUsuariosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding), // Mantener el padding del Scaffold
                        contentAlignment = Alignment.Center
                    ) {
                        // Mostrar los datos de los usuarios con margen ajustado
                        MostrarDatosUsuarios(modifier = Modifier.padding(16.dp)) // Añadir padding para centrar el contenido
                    }
                }
            }
        }
    }
}

// Composable para mostrar los datos de los usuarios
@Composable
fun MostrarDatosUsuarios(modifier: Modifier = Modifier) {
    // Instanciar la clase ListaUsuarios
    val listaUsuarios = ListaUsuarios()

    // Crear y agregar usuarios
    val usuario1 = Usuario(nombre = "Rick Grimes", edad = 45, trabajo = "Sheriff")
    val usuario2 = Usuario(nombre = "Walter White", edad = 60, trabajo = "Profesor de química", referencia = usuario1)
    val usuario3 = Usuario(nombre = "Lucía", edad = 28, trabajo = "Abogada", referencia = usuario2)
    val usuario4 = Usuario(nombre = "Carlos", edad = 40, trabajo = "Profesor")
    val usuario5 = Usuario(nombre = "Laura", edad = 25, trabajo = "Diseñadora")

    listaUsuarios.agregarUsuario(usuario1)
    listaUsuarios.agregarUsuario(usuario2)
    listaUsuarios.agregarUsuario(usuario3)
    listaUsuarios.agregarUsuario(usuario4)
    listaUsuarios.agregarUsuario(usuario5)

    // Eliminar un usuario para la demostración
    listaUsuarios.eliminarUsuario("Walter White")

    // Mostrar la lista de usuarios
    val usuariosString = listaUsuarios.mostrarLista()

    // Usar un Text composable para mostrar los usuarios en pantalla con un modifier que incluye padding
    Text(text = usuariosString, modifier = modifier.padding(16.dp)) // Ajustar padding adicional
}

@Preview(showBackground = true)
@Composable
fun PreviewMostrarDatosUsuarios() {
    DatosUsuariosTheme {
        MostrarDatosUsuarios()
    }
}
