package pe.edu.idat.appminimarketmajoni.retrofit.response

data class ProductoResponse(
    val id_producto: Int,
    val codigo: String,
    val nombre: String,
    val descripcion: String,
    val cantidad: Int,
    val precio_unitario: Double,
    val imagen: String?,
    val id_proveedor: Int,
    val id_categoria: Int
)