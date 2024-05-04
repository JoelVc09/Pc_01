package com.example.pc_01

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Obtener el promedio pasado como extra del Intent
        val promedio = intent.getDoubleExtra("promedio", 0.0)

        // Buscar el TextView con el id idresult
        val tvResult: TextView = findViewById(R.id.idresult)

        // Mostrar el promedio en el TextView
        tvResult.text = promedio.toString()

        val tvResult2: TextView = findViewById(R.id.tvresult2)

        // Establecer el texto de tvresult2 basado en el resultado
        if (promedio <= 10) {
            tvResult2.text = "Desaprobaste"
            tvResult2.setTextColor(ContextCompat.getColor(this, R.color.colorRed)) // Color Rojo
        } else {
            tvResult2.text = "Aprobaste"
            tvResult2.setTextColor(ContextCompat.getColor(this, R.color.colorGreen))
        }
    }
}