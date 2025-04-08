package com.example.sesion

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }
}

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal) // Asegúrate de que este es el layout correcto

        // Encuentra el LinearLayout correspondiente al producto
        val item1 = findViewById<LinearLayout>(R.id.prod1)

        // Configura el listener para el click
        item1.setOnClickListener {
            // Muestra un Toast para confirmar que se hizo el clic
            Toast.makeText(this, "Click detectado en item1", Toast.LENGTH_SHORT).show()

            // Inicia la actividad VerProducto
            val intent = Intent(this, VerProducto::class.java)
            startActivity(intent)
        }
    }
}


