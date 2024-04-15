package pe.edu.idat.appminimarketmajoni.model.db

data class ProductoDetalle (
    val id_producto: Int,
    val codigo: String,
    val nombre: String,
    val descripcion: String,
    val cantidad: Int,
    val precio_unitario: Double,
    val imagen: String,
    val proveedor: Proveedor,
    val categoria: Categoria
)