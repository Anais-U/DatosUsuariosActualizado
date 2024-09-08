package cl.bootcamp.datosusuarios

// Clase Usuario
class Usuario(
    val nombre: String,
    val edad: Int,
    val trabajo: String?,  // Trabajo puede ser nulo
    val referencia: Usuario?  // Referencia puede ser otro usuario o nulo
) {

    // Función para mostrar los datos del usuario
    fun mostrarDatos(): String {
        val trabajoStr = trabajo ?: "Desempleado"
        val referenciaStr = if (referencia != null) {
            "Fue citado por: ${referencia.nombre} de ${referencia.edad} años."
        } else {
            "No fue citado por nadie."
        }

        return """
            Nombre: $nombre
            Edad: $edad años
            Trabajo: $trabajoStr
            $referenciaStr
        """.trimIndent()
    }
}

