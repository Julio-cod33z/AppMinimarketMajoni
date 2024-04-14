package pe.edu.idat.appminimarketmajoni.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.appminimarketmajoni.R
import pe.edu.idat.appminimarketmajoni.databinding.ActivityLoginBinding
import pe.edu.idat.appminimarketmajoni.retrofit.response.LoginResponse
import pe.edu.idat.appminimarketmajoni.util.AppMensaje
import pe.edu.idat.appminimarketmajoni.util.TipoMensaje
import pe.edu.idat.appminimarketmajoni.viewmodel.AuthViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        authViewModel.loginResponse.observe(this, Observer {
            response -> obtenerDatosLogin(response!!)
        })

        binding.btnIngresar.setOnClickListener(this)
    }

    private fun obtenerDatosLogin(response: LoginResponse) {
        if (response.registro) {
            // Usuario autenticado, redirigir a la siguiente actividad
            startActivity(Intent(applicationContext, MenuPrincipalActivity::class.java))
        } else {
            // Usuario no autenticado, mostrar mensaje de error
            AppMensaje.enviarMensaje(binding.root, response.mensaje, TipoMensaje.ERROR)
        }
        binding.btnIngresar.isEnabled = true
    }

    override fun onClick(vista: View) {
        when(vista.id) {
            R.id.btnIngresar -> autenticarUsuario()
        }
    }

    private fun autenticarUsuario() {
        binding.btnIngresar.isEnabled = false
        authViewModel.autenticarUsuario(binding.etUsuario.text.toString(),
            binding.etContrasena.text.toString())
    }
}