package pe.edu.idat.appminimarketmajoni.view.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import pe.edu.idat.appminimarketmajoni.databinding.FragmentGenerarInformeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class GenerarInformeFragment : Fragment() {

    private var _binding: FragmentGenerarInformeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGenerarInformeBinding.inflate(inflater, container, false)

        binding.etdFechaInforme.setOnClickListener {
            mostrarDatePicker(binding.etdFechaInforme)
        }

        return binding.root
    }

    private fun mostrarDatePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, monthOfYear, dayOfMonth)
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            editText.setText(dateFormat.format(selectedDate.time))
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        datePicker.show()
    }
}