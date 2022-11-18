package ni.edu.uca.sharedpreferences

import android.content.Context

class Preferencias(val contex: Context) {

    val SHARED_NAME = "BaseDatos"
    val SHARED_USER_NAME = "username"
    val SHARED_CK = "Ck"


    val storage = contex.getSharedPreferences(SHARED_NAME, 0)

    fun saveName(name:String){
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }
    fun saveCk(Ck:Boolean){
        storage.edit().putBoolean(SHARED_CK,Ck).apply()
    }
    fun getName():String{
       return storage.getString(SHARED_USER_NAME, "")!!
    }
    fun getCk():Boolean{
        return storage.getBoolean(SHARED_CK, false)
    }
    fun wipe(){
        storage.edit().clear().apply()
    }
}