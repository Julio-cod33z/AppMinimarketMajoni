package pe.edu.idat.appminimarketmajoni.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.appminimarketmajoni.retrofit.MajoniCliente
import pe.edu.idat.appminimarketmajoni.retrofit.request.LoginRequest
import pe.edu.idat.appminimarketmajoni.retrofit.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {
    var loginResponse = MutableLiveData<LoginResponse>()

    fun autenticarUsuario(loginRequest: LoginRequest): MutableLiveData<LoginResponse>
    {
        val call: Call<LoginResponse> = MajoniCliente.retrofitService.login(loginRequest)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(p0: Call<LoginResponse>, p1: Response<LoginResponse>) {
                loginResponse.value = p1.body()
            }
            override fun onFailure(p0: Call<LoginResponse>, p1: Throwable) {
                Log.e( "ErrorLogin", p1.message.toString())
            }
        })
        return loginResponse
    }
}