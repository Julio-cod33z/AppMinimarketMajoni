package pe.edu.idat.appminimarketmajoni.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.appminimarketmajoni.databinding.ItemProductoBinding

class ProductoAdapter(/*private var listaproducto: List<Producto>,
                      private val onDeleteClickListener: (Producto) -> Unit*/)
    /*: RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>()*/ {
    /*inner class ProductoViewHolder(private val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemProductoBinding.inflate(inflater, parent, false)
            return ProductoViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
            val producto = productos[position]
            holder.bind(producto)
        }

        override fun getItemCount(): Int = productos.size



            fun bind(producto: Producto) {
                binding.tvNombreProducto.text = producto.nombre
                binding.tvCantidad.text = producto.cantidad.toString()
                binding.tvPrecio.text = producto.precio.toString()
                binding.tvCategoria.text = producto.categoria

                binding.btnEliminarProducto.setOnClickListener {
                    onDeleteClickListener(producto)
                }
            }
        }
    }*/
}