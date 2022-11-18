package ni.edu.uca.sharedpreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ni.edu.uca.sharedpreferences.SharedP.Companion.preferencias
import ni.edu.uca.sharedpreferences.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    fun initUI() {
        binding.btnClose.setOnClickListener {
            preferencias.wipe()
            onBackPressed()
        }
        val userName = preferencias.getName()
        binding.tvName.text = "Bienvenido $userName"
        if (preferencias.getCk()) {
            setCkColor()

        }
    }

    fun setCkColor() {
        binding.container.setBackgroundColor(ContextCompat.getColor(this, R.color.Personal))
    }

}

