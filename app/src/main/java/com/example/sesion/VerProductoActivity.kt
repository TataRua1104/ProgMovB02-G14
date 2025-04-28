package com.example.sesion

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VerProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.producto) // Asegúrate de que este es el nombre de tu layout

        // Obtener el objeto Producto del Intent (forma no deprecated)
        val producto = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("producto", Producto::class.java)
        } else {
            intent.getSerializableExtra("producto") as? Producto
        }

        // Obtener referencias a las vistas
        val productImage: ImageView = findViewById(R.id.product_image)
        val productTitle: TextView = findViewById(R.id.product_title)
        val productPrice: TextView = findViewById(R.id.product_price)
        val productDescription: TextView = findViewById(R.id.product_description)

        // Mostrar los datos del producto si se recibió correctamente
        producto?.let {
            productTitle.text = it.nombre
            productPrice.text = "$${it.precio}"
            productImage.setImageResource(it.imagenResId)
            // Aquí podrías también obtener y mostrar la descripción si la tienes en tu clase Producto
        }
    }
}