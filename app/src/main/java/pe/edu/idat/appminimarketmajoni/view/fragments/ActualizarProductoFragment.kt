package pe.edu.idat.appminimarketmajoni.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.idat.appminimarketmajoni.databinding.FragmentActualizarProductoBinding
import pe.edu.idat.appminimarketmajoni.view.api.ProductoService
import pe.edu.idat.appminimarketmajoni.view.model.Producto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActualizarProductoFragment : Fragment() {

    private var _binding: FragmentActualizarProductoBinding? = null
    private val binding get() = _binding!!

    private lateinit var productoService: ProductoService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActualizarProductoBinding.inflate(inflater, container, false)

        val retrofit = Retrofit.Builder()
            .baseUrl("URL_BASE_DE_TU_API")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        productoService = retrofit.create(ProductoService::class.java)

        // Configurar listener para el botón de búsqueda
        binding.button3.setOnClickListener {
            buscarProductoPorCodigo()
        }

        return binding.root
    }

    private fun buscarProductoPorCodigo() {
        val codigo = binding.autoCompleteTextView.text.toString().toInt()

        // Llamar al método de la API para buscar el producto por su código
        val call = productoService.obtenerProductoPorCodigo(codigo)
        call.enqueue(object : Callback<Producto> {
            override fun onResponse(call: Call<Producto>, response: Response<Producto>) {
                if (response.isSuccessful) {
                    val producto = response.body()
                    // Mostrar los detalles del producto en la interfaz de usuario
                    producto?.let { mostrarDetallesProducto(it) }
                } else {
                    // Manejar el caso en el que no se encuentre el producto
                    // Puedes mostrar un mensaje de error o limpiar los campos
                }
            }

            override fun onFailure(call: Call<Producto>, t: Throwable) {
                // Manejar errores de comunicación con la API
            }
        })
    }

    private fun mostrarDetallesProducto(producto: Producto) {
        // Mostrar los detalles del producto en los campos de la interfaz de usuario
        binding.autoCompleteTextView.setText(producto.codigo.toString())
        binding.autoCompleteTextView2.setText(producto.nombre)
        binding.editTextNumber2.setText(producto.cantidad.toString())
        binding.autoCompleteTextView3.setText(producto.precio.toString())
        binding.editTextTextMultiLine2.setText(producto.descripcion)
        Glide.with(this)
            .load(producto.imagenUrl)
            .into(binding.imageView3)

    }
}