package pe.edu.idat.appminimarketmajoni.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.appminimarketmajoni.R
import pe.edu.idat.appminimarketmajoni.databinding.FragmentActualizarProductoBinding
import pe.edu.idat.appminimarketmajoni.databinding.FragmentEliminarProductoBinding
import pe.edu.idat.appminimarketmajoni.view.adapter.ProductoAdapter

class EliminarProductoFragment : Fragment() {

    private var _binding: FragmentEliminarProductoBinding? = null
    private val binding get() = _binding!!

    private lateinit var productoAdapter: ProductoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEliminarProductoBinding.inflate(inflater, container, false)
        val view = binding.root

        productoAdapter = ProductoAdapter(emptyList()) { producto ->
            // Aquí se manejará la lógica para eliminar el producto seleccionado
            eliminarProducto(producto.id)
        }

        binding.recyclerViewProductos.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = productoAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        return view
    }

    private fun eliminarProducto(id: String) {
        // Aquí debes enviar la solicitud al servidor para eliminar el producto con el ID proporcionado
        // Puedes usar Retrofit u otra biblioteca de red para esto
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}