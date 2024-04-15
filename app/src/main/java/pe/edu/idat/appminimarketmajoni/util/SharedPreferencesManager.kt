package pe.edu.idat.appminimarketmajoni.util

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager {
    private val APP_SETTINGS_FILE = "APP_SETTING"
    private fun getSharedPreferences(): SharedPreferences {
        return MiApp.applicationContext.getSharedPreferences(APP_SETTINGS_FILE,
            Context.MODE_PRIVATE
        )
    }

    fun setSomeBooleanValue(nombre: String, valor: Boolean) {
        val editor = getSharedPreferences().edit()
        editor.putBoolean(nombre, valor)
        editor.commit()
    }

    fun getSomeBooleanValue(nombre: String): Boolean {
        return getSharedPreferences().getBoolean(nombre, false)
    }

    fun setSomeStringValue(nombre: String, valor: String) {
        val editor = getSharedPreferences().edit()
        editor.putString(nombre, valor)
        editor.commit()
    }

    fun getSomeStringValue(nombre: String): String {
        return getSharedPreferences().getString(nombre, "").toString()
    }

    fun deletePreferences(nombre: String) {
        getSharedPreferences().edit().remove(nombre).apply()
    }
}