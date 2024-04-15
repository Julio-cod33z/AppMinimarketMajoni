package pe.edu.idat.appminimarketmajoni.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pe.edu.idat.appminimarketmajoni.databinding.FragmentAgregarProductoBinding
import pe.edu.idat.appminimarketmajoni.view.api.ProductoService
import pe.edu.idat.appminimarketmajoni.view.model.Producto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.Toast



class AgregarProductoFragment : Fragment() {

    private var _binding: FragmentAgregarProductoBinding? = null
    private val binding get() = _binding!!

    private lateinit var productoService: ProductoService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAgregarProductoBinding.inflate(inflater, container, false)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8093/productos")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        productoService = retrofit.create(ProductoService::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button.setOnClickListener {
            agregarProducto()
        }
    }

    private fun agregarProducto() {

        val codigo = binding.editTextText.text.toString().toInt()
        val nombre = binding.editTextText2.text.toString()
        val cantidad = binding.editTextNumber.text.toString().toInt()
        val precio = binding.editTextNumberDecimal.text.toString().toDouble()
        val descripcion = binding.editTextTextMultiLine.text.toString()
        val imagenUrl = "URL_IMAGEN_POR_DEFECTO" // Puedes proporcionar una URL de imagen por defecto si no tienes una en el formulario
        val categoria = binding.spinner2.selectedItem.toString()

        val nuevoProducto = Producto(
            codigo,
            nombre,
            cantidad,
            precio,
            descripcion,
            imagenUrl,
            categoria
        )

        // Llamar al método de la API para agregar el producto
        val call = productoService.crearProducto(nuevoProducto)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), "Producto agregado exitosamente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Error al agregar el producto", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Manejar errores de comunicación con la API
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}