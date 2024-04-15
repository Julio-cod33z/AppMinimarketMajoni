package pe.edu.idat.appminimarketmajoni.view.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import pe.edu.idat.appminimarketmajoni.R
import pe.edu.idat.appminimarketmajoni.databinding.FragmentActualizarProductoBinding
import java.io.File

class ActualizarProductoFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentActualizarProductoBinding? = null
    private val binding get() = _binding!!
    private lateinit var file: File
    private var rutaFotoActual = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActualizarProductoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnTomarFoto2 -> tomarFoto()
        }
    }

    private fun tomarFoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{
            it.resolveActivity(requireContext().packageManager).also {
                    componente ->
                crearArchivoFoto()
                val fotoUri: Uri =
                    obtenerContenidoUri(file)
                /*FileProvider.getUriForFile(
                    requireContext(),
                    "pe.edu.idat.appminimarketmajoni.fileprovider",
                    file
                )*/
                it.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri)
            }
        }
        abrirCamara.launch(intent)
    }

    private val abrirCamara = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == AppCompatActivity.RESULT_OK){
            /*val data = result.data!!
            val imagenBitMap = data.extras!!.get("data") as Bitmap*/
            binding.ivFoto2.setImageBitmap(obtenerImagenBitmap())
        }
    }

    private fun obtenerImagenBitmap(): Bitmap {
        return BitmapFactory.decodeFile(file.toString())
    }

    private fun obtenerContenidoUri(archivoFoto: File): Uri {
        return FileProvider.getUriForFile(requireContext(),
            "pe.edu.idat.appminimarketmajoni.fileprovider",
            archivoFoto)
    }

    private fun crearArchivoFoto(){
        val directorioImg = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        file = File.createTempFile("IMG_${System.currentTimeMillis()}_"
            ,".jpg", directorioImg)
        rutaFotoActual = file.absolutePath
    }
}