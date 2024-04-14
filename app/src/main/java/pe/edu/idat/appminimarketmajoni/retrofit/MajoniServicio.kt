package pe.edu.idat.appminimarketmajoni.retrofit

import pe.edu.idat.appminimarketmajoni.retrofit.request.LoginRequest
import pe.edu.idat.appminimarketmajoni.retrofit.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MajoniServicio {
    @POST("usuarios/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}