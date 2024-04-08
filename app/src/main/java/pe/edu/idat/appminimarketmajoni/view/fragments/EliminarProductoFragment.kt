package pe.edu.idat.appminimarketmajoni.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.idat.appminimarketmajoni.R
import pe.edu.idat.appminimarketmajoni.databinding.FragmentActualizarProductoBinding
import pe.edu.idat.appminimarketmajoni.databinding.FragmentEliminarProductoBinding

class EliminarProductoFragment : Fragment() {

    private var _binding: FragmentEliminarProductoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEliminarProductoBinding.inflate(inflater, container, false)

        return binding.root
    }
}