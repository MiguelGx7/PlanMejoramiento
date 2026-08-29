package com.miguel.planmejoramiento

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miguel.planmejoramiento.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        const val EXTRA_RESULTADO = "extra_resultado"
        const val NOTA_MINIMA = 0.0
        const val NOTA_MAXIMA = 5.0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            procesarNota()
        }
    }

    private fun procesarNota() {
        val texto = binding.etNota.text.toString()

        if (texto.isBlank()) {
            binding.tvResultado.text = "Error: ingrese una nota"
            return
        }

        val nota = texto.toDoubleOrNull()

        if (nota == null || nota < NOTA_MINIMA || nota > NOTA_MAXIMA) {
            binding.tvResultado.text = "Error: la nota debe estar entre 0 y 5"
            return
        }

        val estado = clasificar(nota)
        binding.tvResultado.text = estado

        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra(EXTRA_RESULTADO, estado)
        startActivity(intent)
    }

    private fun clasificar(nota: Double): String = when {
        nota >= 4.5 -> "Excelente"
        nota >= 3.0 -> "Aprobado"
        else -> "No aprobado"
    }
}
