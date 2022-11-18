package ni.edu.uca.sharedpreferences

import android.app.Application

class SharedP: Application() {
    companion object{
        lateinit var preferencias: Preferencias
    }
    override fun onCreate() {
        super.onCreate()
        preferencias = Preferencias(applicationContext)

    }
}