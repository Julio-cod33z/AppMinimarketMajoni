package pe.edu.idat.appminimarketmajoni.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.idat.appminimarketmajoni.databinding.ActivityLoginBinding
import pe.edu.idat.appminimarketmajoni.view.fragments.AgregarProductoFragment

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener {
            val username = binding.etUsuario.text.toString()
            val password = binding.etContrasena.text.toString()

            if (isValidCredentials(username, password)) {
                startActivity(Intent(applicationContext, MenuPrincipalActivity::class.java))
            } else {
                Toast.makeText(applicationContext, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //VALIDANDO CAMPOS POR EMAIL Y CONTRASEÑA
    private fun isValidCredentials(username: String, password: String): Boolean {

        val validUsernames = listOf("Jonathan", "Angel", "Julio")

        return validUsernames.contains(username) && password == "SYS123"
    }
}