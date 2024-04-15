package pe.edu.idat.appminimarketmajoni.repository

import pe.edu.idat.appminimarketmajoni.model.db.dao.ProductoDao
import pe.edu.idat.appminimarketmajoni.model.db.entity.Producto

class ProductoRepository(private val productoDao: ProductoDao) {

    // Método para obtener todos los productos
    suspend fun obtenerTodosLosProductos(): List<Producto> {
        return productoDao.obtenerTodosLosProductos()
    }

    // Método para obtener un producto por su ID
    suspend fun obtenerProductoPorId(idProducto: Int): Producto {
        return productoDao.obtenerProductoPorId(idProducto)
    }

    // Método para insertar un nuevo producto
    suspend fun insertarProducto(producto: Producto) {
        productoDao.insertarProducto(producto)
    }

    // Método para actualizar un producto existente
    suspend fun actualizarProducto(producto: Producto) {
        productoDao.actualizarProducto(producto)
    }

    // Método para eliminar un producto
    suspend fun eliminarProducto(producto: Producto) {
        productoDao.eliminarProducto(producto)
    }
}