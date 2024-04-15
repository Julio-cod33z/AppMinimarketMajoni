package pe.edu.idat.appminimarketmajoni.view.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import pe.edu.idat.appminimarketmajoni.R
import pe.edu.idat.appminimarketmajoni.databinding.FragmentAgregarProductoBinding
import java.io.File


class AgregarProductoFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentAgregarProductoBinding? = null
    private val binding get() = _binding!!
    private lateinit var file: File
    private var rutaFotoActual = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAgregarProductoBinding.inflate(inflater, container, false)

        binding.btnTomarFoto.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btnTomarFoto -> tomarFoto()
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
                    "pe.edu.idat.appcamara.fileprovider",
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
            binding.ivFoto.setImageBitmap(obtenerImagenBitmap())
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

    /*private fun crearArchivoFoto() {
        val directoriosImg = ContextCompat.getExternalFilesDirs(requireContext(), Environment.DIRECTORY_PICTURES)
        if (directoriosImg.isNotEmpty()) {
            val directorioImg = directoriosImg[0]
            file = File.createTempFile("IMG_${System.currentTimeMillis()}_", ".jpg", directorioImg)
            rutaFotoActual = file.absolutePath
        } else {
            // Maneja el caso donde no se pudo obtener el directorio de imágenes externas
            // Aquí puedes proporcionar una alternativa o lanzar una excepción según sea necesario
        }
    }*/
}