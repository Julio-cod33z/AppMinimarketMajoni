package pe.edu.idat.appminimarketmajoni.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import pe.edu.idat.appminimarketmajoni.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }, 4000)
    }
}