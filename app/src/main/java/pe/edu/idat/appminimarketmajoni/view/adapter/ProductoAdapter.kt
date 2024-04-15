package pe.edu.idat.appminimarketmajoni.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pe.edu.idat.appminimarketmajoni.R
import pe.edu.idat.appminimarketmajoni.model.db.entity.Producto

class ProductoAdapter(private val productos: List<Producto>, private val onProductoEliminarClickListener: OnProductoEliminarClickListener
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val currentItem = productos[position]

        // Cargar imagen con Glide si tienes una URL de imagen en tu modelo Producto
        // Si no, puedes omitir esta parte y configurar la imagen según sea necesario
        Glide.with(holder.itemView)
            .load(currentItem.imagen)
            .apply(RequestOptions().placeholder(R.drawable.ic_camara))
            .into(holder.imageView)

        holder.nombreTextView.text = currentItem.nombre
        holder.cantidadTextView.text = currentItem.cantidad.toString()
        holder.precioTextView.text = currentItem.precio_unitario.toString()
        holder.categoriaTextView.text = currentItem.id_categoria.toString()

        // Manejar el clic en el botón "Eliminar"
        holder.eliminarButton.setOnClickListener {
            onProductoEliminarClickListener.onProductoEliminarClick(currentItem)
        }
    }

    interface OnProductoEliminarClickListener {
        fun onProductoEliminarClick(producto: Producto)
    }


    override fun getItemCount() = productos.size

    inner class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivProducto)
        val nombreTextView: TextView = itemView.findViewById(R.id.tvNombreProducto)
        val cantidadTextView: TextView = itemView.findViewById(R.id.tvCantidad)
        val precioTextView: TextView = itemView.findViewById(R.id.tvPrecio)
        val categoriaTextView: TextView = itemView.findViewById(R.id.tvCategoria)
        val eliminarButton: Button = itemView.findViewById(R.id.btnEliminarProducto)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
