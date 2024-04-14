package pe.edu.idat.appminimarketmajoni.util

import android.app.Application
import android.content.Context

class MiApp : Application() {
    init {
        instance = this
    }

    companion object {
        lateinit var instance: MiApp
            private set
        val applicationContext: Context
            get() {
            return instance.applicationContext
        }
    }
}