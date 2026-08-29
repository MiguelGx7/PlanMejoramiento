package com.miguel.planmejoramiento

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miguel.planmejoramiento.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val estado = intent.getStringExtra(MainActivity.EXTRA_RESULTADO)

        binding.tvDato.text = estado
    }
}
