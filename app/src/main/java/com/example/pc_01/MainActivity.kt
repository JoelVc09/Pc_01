package com.example.pc_01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val etParcial: EditText = findViewById(R.id.idparcial)
        val etFinal: EditText = findViewById(R.id.idfinal)
        val etPEP: EditText = findViewById(R.id.idtarea)
        val btnCalcularPromedio: Button = findViewById(R.id.btnCal)

        btnCalcularPromedio.setOnClickListener {
            val parcial = etParcial.text.toString().toDoubleOrNull() ?: 0.0
            val examenFinal = etFinal.text.toString().toDoubleOrNull() ?: 0.0
            val pep = etPEP.text.toString().toDoubleOrNull() ?: 0.0

            val promedio = (parcial + examenFinal + pep) / 3

            // Crear un Intent para iniciar MainActivity2
            val intent = Intent(this, MainActivity2::class.java)
            // Agregar el promedio como un extra al Intent
            intent.putExtra("promedio", promedio)
            // Iniciar MainActivity2
            startActivity(intent)
        }



    }
}