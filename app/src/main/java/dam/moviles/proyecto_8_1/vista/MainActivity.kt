package dam.moviles.proyecto_8_1.vista

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dam.moviles.proyecto_8_1.R
import dam.moviles.proyecto_8_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicializarBinding()
        setContentView(binding.root)
    }

    private fun inicializarBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}