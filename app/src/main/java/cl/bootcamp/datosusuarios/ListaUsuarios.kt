package cl.bootcamp.datosusuarios

class ListaUsuarios {
    private val lista = mutableListOf<Usuario>()

    // Función para agregar usuarios
    fun agregarUsuario(usuario: Usuario) {
        lista.add(usuario)
        println("${usuario.nombre} ha sido agregado.")
    }

    // Función para eliminar usuarios por nombre
    fun eliminarUsuario(nombre: String) {
        val usuario = lista.find { it.nombre == nombre }
        if (usuario != null) {
            lista.remove(usuario)
            println("$nombre ha sido eliminado.")
        } else {
            println("Usuario no encontrado.")
        }
    }

    // Función para mostrar la lista de usuarios
    fun mostrarLista(): String {
        return if (lista.isEmpty()) {
            "La lista de usuarios está vacía."
        } else {
            lista.joinToString(separator = "\n\n") { it.mostrarDatos() }
        }
    }
}
