package CarritoDeCompras
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val carrito = CarritoDeCompras()

    // Se crean algunos productos
    val productos = mutableListOf<Producto>(
        Producto("Camiseta", 15.99, 10),          // Producto con nombre, precio y cantidad disponible
        Producto("Pantalón", 29.99, 5),
        Producto("Zapatos", 39.99, 3),
        Producto("Overoles", 21.99, 2),
        Producto("Calcetas", 4.99, 20),
        Producto("Zapatillas", 32.99, 0),         // Producto sin inventario (fuera de stock)
        Producto("Pañuelos", 13.99, 5),
        Producto("Corbata", 29.99, 15),
        Producto("Guantes", 15.99, 6),
    )

    var salir = false

    // Bucle principal del programa
    while (!salir) {
        println("\n=== MENÚ ===")
        println("1. Ver productos disponibles")
        println("2. Agregar productos al carrito")
        println("3. Eliminar productos del carrito")
        println("4. Ver carrito")
        println("5. Ir a pagar")
        println("6. Salir")

        print("Por favor, seleccione una opción: ")
        // Leer la opción del usuario
        when (scanner.nextInt()) {
            1 -> mostrarProductos(productos)                           // Mostrar productos disponibles
            2 -> agregarAlCarrito(scanner, productos, carrito)        // Agregar productos al carrito
            3 -> eliminarDelCarrito(scanner, carrito)                 // Eliminar productos del carrito
            4 -> carrito.mostrarCarrito()                             // Mostrar contenido del carrito
            5 -> {
                println("\nIr a pagar:")
                // Lógica para pagar y vaciar el carrito
            }
            6 -> {
                salir = true                                           // Salir del bucle si se selecciona la opción 6
                println("Gracias por su visita. ¡Hasta luego!")
            }
            else -> println("Opción no válida. Por favor, seleccione una opción válida.")
        }
    }
}

// Función para mostrar los productos disponibles
fun mostrarProductos(productos: List<Producto>) {
    println("\nProductos disponibles:")
    for ((index, producto) in productos.withIndex()) {
        println("${index + 1}. $producto")
    }
}

// Función para agregar productos al carrito
fun agregarAlCarrito(scanner: Scanner, productos: List<Producto>, carrito: CarritoDeCompras) {
    println("\nSeleccione el número del producto que desea agregar al carrito:")
    mostrarProductos(productos)
    val opcion = scanner.nextInt()
    if (opcion in 1..productos.size) {
        val productoSeleccionado = productos[opcion - 1]
        if (productoSeleccionado.cantidadDisponible > 0) {               // Verificar si hay stock disponible
            println("Ingrese la cantidad de ${productoSeleccionado.nombre} que desea agregar al carrito:")
            var cantidad = scanner.nextInt()
            if (cantidad > 0) {
                if (cantidad <= productoSeleccionado.cantidadDisponible) {  // Verificar si la cantidad es válida
                    carrito.agregarProducto(productoSeleccionado, cantidad)
                    println("$cantidad ${productoSeleccionado.nombre} agregado(s) al carrito.")
                } else {
                    println("La cantidad ingresada supera el inventario disponible (${productoSeleccionado.cantidadDisponible}).")
                }
            } else {
                println("La cantidad ingresada debe ser mayor que 0.")
            }
        } else {
            println("Lo sentimos, el producto seleccionado está fuera de stock.")
        }
    } else {
        println("Opción no válida.")
    }
}

// Función para eliminar productos del carrito
fun eliminarDelCarrito(scanner: Scanner, carrito: CarritoDeCompras) {
    println("\nSeleccione el número del producto que desea eliminar del carrito:")
    carrito.mostrarCarrito()
    val opcion = scanner.nextInt()
    if (opcion in 1..carrito.productosSeleccionados.size) {
        val productoSeleccionado = carrito.productosSeleccionados[opcion - 1].first
        carrito.eliminarProducto(productoSeleccionado)
        println("${productoSeleccionado.nombre} eliminado del carrito.")
    } else {
        println("Opción no válida.")
    }
}
