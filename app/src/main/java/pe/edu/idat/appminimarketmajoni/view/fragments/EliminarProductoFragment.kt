package pe.edu.idat.appminimarketmajoni.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.SearchView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.appminimarketmajoni.R
import pe.edu.idat.appminimarketmajoni.model.db.entity.Producto
import pe.edu.idat.appminimarketmajoni.view.adapter.ProductoAdapter

class EliminarProductoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductoAdapter
    private lateinit var productos: MutableList<Producto>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_eliminar_producto, container, false)

        // Inicializar la lista de productos desde la base de datos al abrir la ventana
        obtenerProductosDesdeBaseDeDatos()

        // Configurar RecyclerView y asignar el adaptador
        recyclerView = view.findViewById(R.id.rvProductos)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ProductoAdapter(productos, object : ProductoAdapter.OnProductoEliminarClickListener {
            override fun onProductoEliminarClick(producto: Producto) {
                // Manejar el clic en el botón "Eliminar" del producto
                eliminarProducto(producto)
            }
        })
        recyclerView.adapter = adapter

        // Configurar SearchView para filtrar productos por nombre
        val searchView: SearchView = view.findViewById(R.id.searchView2)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filtrarPorNombre(newText)
                return true
            }
        })

        // Configurar Spinner para filtrar productos por categoría
        val spinner: Spinner = view.findViewById(R.id.spCategoria3)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val categoriaSeleccionada = spinner.selectedItem.toString()
                adapter.filtrarPorCategoria(categoriaSeleccionada)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hacer nada
            }
        }

        return view
    }

    private fun obtenerProductosDesdeBaseDeDatos() {
        // Aquí deberías obtener los productos de la base de datos
        // y asignarlos a la lista de productos
        // Por ahora, solo devuelve una lista de productos de ejemplo
        productos = mutableListOf(
            Producto("1", "Producto 1"),
            Producto("2", "Producto 2"),
            Producto("3", "Producto 3")
        )
    }

    private fun eliminarProducto(producto: Producto) {
        // Eliminar el producto de la lista de productos
        productos.remove(producto)
        adapter.notifyDataSetChanged()
    }
}