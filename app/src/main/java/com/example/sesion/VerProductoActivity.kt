package com.example.sesion

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VerProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.producto)

        val producto = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("producto", Producto::class.java)
        } else {
            intent.getSerializableExtra("producto") as? Producto
        }

        val productImage: ImageView = findViewById(R.id.product_image)
        val productTitle: TextView = findViewById(R.id.product_title)
        val productPrice: TextView = findViewById(R.id.product_price)
        val productDescription: TextView = findViewById(R.id.product_description)
        val viewVideoButton: Button = findViewById(R.id.view_video_button)
        val contactSellerButton: Button = findViewById(R.id.contact_seller_button)

        producto?.let {
            productTitle.text = it.nombre
            productPrice.text = "$${it.precio}"
            productImage.setImageResource(it.imagenResId)
            // productDescription.text = it.descripcion // Si agregaste descripción

            // Configurar OnClickListener para el botón de ver video
            it.videoUrl?.let { url ->
                viewVideoButton.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                }
            } ?: run {
                // Si no hay URL de video, puedes deshabilitar el botón o cambiar su texto
                viewVideoButton.isEnabled = false
                viewVideoButton.text = "Video no disponible"
            }

            // Configurar OnClickListener para el botón de contactar al vendedor (WhatsApp)
            it.whatsappUrl?.let { url ->
                contactSellerButton.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                }
            } ?: run {
                // Si no hay URL de WhatsApp, puedes deshabilitar el botón o cambiar su texto
                contactSellerButton.isEnabled = false
                contactSellerButton.text = "Contacto no disponible"
            }
        }
    }
}