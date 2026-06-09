package patterns.creational

interface Producto {
    fun descripcion(): String
}

abstract class Taller {
    fun prepararPedido(): String {
        val producto = crearProducto()
        return "Pedido preparado para ${producto.descripcion()}"
    }

    protected abstract fun crearProducto(): Producto
}

class TallerLocal : Taller() {
    override fun crearProducto(): Producto = ProductoLocal()
}

class ProductoLocal : Producto {
    override fun descripcion(): String = "Producto local creado por TallerLocal"
}

class FactoryMethodDemo {
    fun ejecutar(): String {
        val taller: Taller = TallerLocal()
        return taller.prepararPedido()
    }
}
