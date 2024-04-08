package pe.edu.idat.appminimarketmajoni.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pe.edu.idat.appminimarketmajoni.R
import pe.edu.idat.appminimarketmajoni.databinding.FragmentMenuPrincipalBinding


class MenuPrincipalFragment : Fragment() {

    private var _binding: FragmentMenuPrincipalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuPrincipalBinding.inflate(inflater, container, false)

        binding.cvAgregarProductos.setOnClickListener {
            findNavController().navigate(R.id.agregarProductoFragment)
        }

        binding.cvActualizarProductos.setOnClickListener {
            findNavController().navigate(R.id.actualizarProductoFragment)
        }

        binding.cvEliminarProductos.setOnClickListener {
            findNavController().navigate(R.id.eliminarProductoFragment)
        }

        binding.cvGenerarInformes.setOnClickListener {
            findNavController().navigate(R.id.generarInformeFragment)
        }

        return binding.root
    }
}