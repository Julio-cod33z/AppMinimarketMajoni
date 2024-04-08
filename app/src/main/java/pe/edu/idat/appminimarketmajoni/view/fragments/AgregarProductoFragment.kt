package pe.edu.idat.appminimarketmajoni.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pe.edu.idat.appminimarketmajoni.databinding.FragmentAgregarProductoBinding


class AgregarProductoFragment : Fragment() {

    private var _binding: FragmentAgregarProductoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAgregarProductoBinding.inflate(inflater, container, false)

        return binding.root
    }
}