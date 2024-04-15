package pe.edu.idat.appminimarketmajoni.model.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "producto")
data class Producto(
    @PrimaryKey
    val id_producto: Int,
    val codigo: String,
    val nombre: String,
    val descripcion: String,
    val cantidad: Int,
    val precio_unitario: Double,
    val imagen: String,
    val id_proveedor: Int,
    val id_categoria: Int
)