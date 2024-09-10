package cl.bootcamp.datosusuarios

data class Usuario(
    val nombre: String,
    val edad: Int,
    val trabajo: String?,
    val referencia: Usuario? = null
) {
    // Función para mostrar datos sin null
    fun mostrarDatos(): String {
        return "Nombre: $nombre, Edad: $edad" +
                (trabajo?.let { ", Trabajo: $it" } ?: "") +
                (referencia?.let { ", Referencia: ${it.nombre}" } ?: "")
    }
}
