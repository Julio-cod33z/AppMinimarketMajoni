package pe.edu.idat.appminimarketmajoni.view.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "producto")
data class Producto(
    @PrimaryKey
    val codigo: Int,
    val nombre: String,
    val cantidad: Int,
    val precio: Double,
    val descripcion: String,
    val imagenUrl: String,
    val categoria: String
)

