package pe.edu.idat.appminimarketmajoni.view.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pe.edu.idat.appminimarketmajoni.databinding.FragmentAgregarProductoBinding
import pe.edu.idat.appminimarketmajoni.view.api.ProductoService
import pe.edu.idat.appminimarketmajoni.view.model.Producto
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.appminimarketmajoni.databinding.ItemProductoBinding

class ProductoAdapter(
    private val productos: List<Producto>,
    private val onDeleteClickListener: (Producto) -> Unit
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

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

    inner class ProductoViewHolder(private val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {

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
}
