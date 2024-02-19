package CarritoDeCompras

// Definición de la clase CarritoDeCompras
class CarritoDeCompras {
    // Lista mutable que almacenará pares de Producto y su cantidad seleccionada
    val productosSeleccionados = mutableListOf<Pair<Producto, Int>>()

    // Función para agregar un producto al carrito con la cantidad especificada
    fun agregarProducto(producto: Producto, cantidad: Int) {
        productosSeleccionados.add(Pair(producto, cantidad)) // Agrega el par (producto, cantidad) a la lista
    }

    // Función para eliminar un producto del carrito
    fun eliminarProducto(producto: Producto) {
        // Iterador para recorrer la lista de productos seleccionados
        val iterator = productosSeleccionados.iterator()
        // Iterar sobre la lista
        while (iterator.hasNext()) {
            val pair = iterator.next()
            // Verificar si el primer elemento del par es igual al producto dado
            if (pair.first == producto) {
                iterator.remove() // Remover el par de la lista
                break // Salir del bucle una vez que se haya eliminado el producto
            }
        }
    }

    // Función para mostrar el contenido del carrito
    fun mostrarCarrito() {
        println("\nCarrito de compras:")
        // Iterar sobre la lista de productos seleccionados
        for ((index, pair) in productosSeleccionados.withIndex()) {
            // Imprimir el nombre del producto y la cantidad seleccionada
            println("${index + 1}. ${pair.first.nombre} - Cantidad: ${pair.second}")
        }
    }
}
