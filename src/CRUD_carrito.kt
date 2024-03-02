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
            val producto = pair.first
            val cantidad = pair.second
            val precioTotalPorProducto = producto.precio * cantidad
            // Imprimir el nombre del producto, la cantidad seleccionada y el precio total por producto
            println("${index + 1}. ${producto.nombre} - Cantidad: $cantidad - Precio Unit.: ${producto.precio} - Total: $precioTotalPorProducto")
        }
    }

    fun generarFactura() {
        println("\nFactura:")
        println("----------------------------------------------------------------")
        println(String.format("%-20s %-10s %-15s %-15s %-15s", "Producto", "Cantidad", "Precio Unit.", "Total sin IVA", "Total con IVA"))
        println("----------------------------------------------------------------")

        var subtotalGeneral = 0.0 //Total
        var totalGeneralConIVA = 0.0 //Total + IVA
        val iva = 0.13  // 13% de IVA

        for ((producto, cantidad) in productosSeleccionados) {
            val totalSinIVA = producto.precio * cantidad //Calculo de Cantidad de productos * precio
            val totalConIVA = totalSinIVA * (1 + iva)
            println(String.format("%-20s %-10d $%-14.2f $%-14.2f $%-14.2f", producto.nombre, cantidad, producto.precio, totalSinIVA, totalConIVA))
            subtotalGeneral += totalSinIVA
            totalGeneralConIVA += totalConIVA
        }

        println("----------------------------------------------------------------")
        println(String.format("%-20s %-10s %-15s $%-14.2f", "Subtotal general:", "", "", subtotalGeneral))
        println(String.format("%-20s %-10s %-15s $%-14.2f", "Total general con IVA:", "", "", totalGeneralConIVA))
        println("----------------------------------------------------------------")


        productosSeleccionados.clear()
    }



}
