package pe.edu.idat.appminimarketmajoni.model.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import pe.edu.idat.appminimarketmajoni.model.db.entity.Producto

@Dao
interface ProductoDao {

    // Insertar un nuevo producto en la base de datos
    @Insert
    suspend fun insertarProducto(producto: Producto)

    // Actualizar un producto existente en la base de datos
    @Update
    suspend fun actualizarProducto(producto: Producto)

    // Eliminar un producto de la base de datos
    @Delete
    suspend fun eliminarProducto(producto: Producto)

    // Obtener todos los productos de la base de datos
    @Query("SELECT * FROM producto")
    suspend fun obtenerTodosLosProductos(): List<Producto>

    // Obtener un producto por su ID de la base de datos
    @Query("SELECT * FROM producto WHERE id_producto = :idProducto")
    suspend fun obtenerProductoPorId(idProducto: Int): Producto
}