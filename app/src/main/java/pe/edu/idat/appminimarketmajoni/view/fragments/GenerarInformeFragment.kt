package pe.edu.idat.appminimarketmajoni.view.fragments

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.FileProvider
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.element.Paragraph
import org.w3c.dom.Document
import pe.edu.idat.appminimarketmajoni.databinding.FragmentGenerarInformeBinding
import pe.edu.idat.appminimarketmajoni.retrofit.MajoniCliente
import pe.edu.idat.appminimarketmajoni.retrofit.response.ProductoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.*

class GenerarInformeFragment : Fragment() {

    private var _binding: FragmentGenerarInformeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGenerarInformeBinding.inflate(inflater, container, false)

        val call = MajoniCliente.retrofitService.obtenerDatosInforme()
        call.enqueue(object : Callback<ProductoResponse> {
            override fun onResponse(call: Call<ProductoResponse>, response: Response<ProductoResponse>) {
                if (response.isSuccessful) {
                    val datosInforme = response.body()
                    // Aquí puedes manejar los datos recibidos
                } else {
                    // Manejar error de respuesta
                }
            }

            override fun onFailure(call: Call<ProductoResponse>, t: Throwable) {
                // Manejar error de red
            }
        })


        binding.etdFechaInforme.setOnClickListener {
            mostrarDatePicker(binding.etdFechaInforme)
        }

        binding.btnGenerarInfo.setOnClickListener {
            generarInformePDF()
        }

        binding.btnCompartirInfo.setOnClickListener {
            compartirInformePDF()
        }

        binding.btnGuardarInfo.setOnClickListener {
            guardarInformeEnDispositivo()
        }

        binding.btnVerInfo.setOnClickListener {
            // Aquí puedes implementar la lógica para abrir o visualizar el informe
            // por ejemplo, abrir un visor de archivos PDF si ya tienes un archivo generado
            // o mostrar el contenido en una nueva pantalla de la aplicación
            // Este botón "Ver Informe" es opcional y su implementación depende de tus requisitos
            // Puedes dejar este bloque vacío si no necesitas esta funcionalidad
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

    private fun generarInformePDF() {
        // Generar un archivo PDF
        val pdfFile = File(requireContext().getExternalFilesDir(null), "informe.pdf")
        val document = Document()
        PdfWriter.getInstance(document, FileOutputStream(pdfFile))
        document.open()
        document.add(Paragraph("Contenido del informe"))
        document.close()
    }

    private fun compartirInformePDF() {
        // Compartir el archivo PDF
        val pdfFile = File(requireContext().getExternalFilesDir(null), "informe.pdf")
        val uri = FileProvider.getUriForFile(requireContext(), requireContext().applicationContext.packageName + ".provider", pdfFile)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "application/pdf"
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        startActivity(Intent.createChooser(intent, "CompartirinformePDF"))
    }

    private fun guardarInformeEnDispositivo() {
        // Guardar el informe en el dispositivo
        val informe = "Contenido del informe"
        val file = File(requireContext().getExternalFilesDir(null), "informe.txt")
        file.writeText(informe)

        Toast.makeText(requireContext(), "Informe guardado en ${file.absolutePath}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}