package pe.edu.idat.appminimarketmajoni.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.appminimarketmajoni.repository.AuthRepository
import pe.edu.idat.appminimarketmajoni.retrofit.request.LoginRequest
import pe.edu.idat.appminimarketmajoni.retrofit.response.LoginResponse

class AuthViewModel: ViewModel() {
    var loginResponse: LiveData<LoginResponse>
    private var repository = AuthRepository()

    init {
        loginResponse = repository.loginResponse
    }

    fun autenticarUsuario(nomusuario: String, contrasena: String) {
        loginResponse = repository.autenticarUsuario(
            LoginRequest(nomusuario, contrasena))
    }
}