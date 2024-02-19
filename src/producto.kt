package CarritoDeCompras

// Definición de la clase Producto
class Producto(val nombre: String, var precio: Double, var cantidadDisponible: Int) {
    // Override de la función toString para proporcionar una representación legible del objeto Producto
    override fun toString(): String {
        // Devuelve una cadena que contiene el nombre del producto, su precio y la cantidad disponible
        return "$nombre - Precio: $precio - Disponible: $cantidadDisponible unidades"
    }
}
