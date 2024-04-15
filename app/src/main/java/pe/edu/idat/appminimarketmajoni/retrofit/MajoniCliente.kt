package pe.edu.idat.appminimarketmajoni.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MajoniCliente {

    private var retrofitCliente = OkHttpClient.Builder()
        .connectTimeout(2, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.MINUTES)
        .writeTimeout(15, TimeUnit.MINUTES)
        //.addInterceptor()
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("http://localhost:9905/")
        .client(retrofitCliente)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: MajoniServicio by lazy {
        buildRetrofit().create(MajoniServicio::class.java)
    }
}