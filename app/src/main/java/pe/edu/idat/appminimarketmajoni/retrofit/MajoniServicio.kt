package pe.edu.idat.appminimarketmajoni.retrofit

import pe.edu.idat.appminimarketmajoni.retrofit.request.LoginRequest
import pe.edu.idat.appminimarketmajoni.retrofit.request.ProductoRequest
import pe.edu.idat.appminimarketmajoni.retrofit.response.LoginResponse
import pe.edu.idat.appminimarketmajoni.retrofit.response.ProductoResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MajoniServicio {
    @GET("productos/detalles")
    fun obtenerDatosInforme(): Call<ProductoResponse>

    @POST("usuarios/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}