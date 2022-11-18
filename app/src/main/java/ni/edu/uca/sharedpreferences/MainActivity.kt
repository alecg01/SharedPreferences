package ni.edu.uca.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.sharedpreferences.SharedP.Companion.preferencias
import ni.edu.uca.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        checkUserValues()
    }
    fun checkUserValues(){
    if(preferencias.getName().isNotEmpty())
        goToDetail()
    }

    fun initUI() {
        binding.btnContinue.setOnClickListener { accessToDetail() }
    }

    fun accessToDetail() {
        if (binding.etName.text.toString().isNotEmpty()) {
            preferencias.saveName(binding.etName.text.toString())
            preferencias.saveCk(binding.cbStatus.isChecked)
            goToDetail()
          //Guarda el Usuario
            Toast.makeText(this,"Datos guardados",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@MainActivity,"Digite nombre",Toast.LENGTH_SHORT).show()


        }
    }
    fun goToDetail(){
        startActivity(Intent(this, ResultActivity::class.java))
    }
}