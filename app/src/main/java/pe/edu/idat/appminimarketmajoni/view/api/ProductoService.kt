package pe.edu.idat.appminimarketmajoni.view.api

import pe.edu.idat.appminimarketmajoni.view.model.Producto
import retrofit2.Call
import retrofit2.http.*

interface ProductoService {

    @GET("productos")
    fun obtenerProductos(): Call<List<Producto>>

    @GET("productos/{codigo}")
    fun obtenerProductoPorCodigo(@Path("codigo") codigo: Int): Call<Producto>

    @POST("productos")
    fun crearProducto(@Body producto: Producto): Call<Void>

    @PUT("productos/{id}")
    fun actualizarProducto(@Path("id") id: String, @Body producto: Producto): Call<Void>

    @DELETE("productos/{id}")
    fun eliminarProducto(@Path("id") id: String): Call<Void>

}