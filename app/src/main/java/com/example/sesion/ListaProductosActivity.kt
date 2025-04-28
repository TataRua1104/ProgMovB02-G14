package com.example.sesion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sesion.VerProductoActivity
import androidx.recyclerview.widget.RecyclerView

class ListaProductosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_productos) // Asegúrate de tener este layout

        // Obtener el nombre de la categoría del Intent
        val categoriaNombre = intent.getStringExtra("categoriaNombre")

        // Obtener la lista de productos del Intent
        val productos = intent.getSerializableExtra("productos") as? ArrayList<Producto>

        // Configurar la barra de acción (si la tienes) con el nombre de la categoría
        supportActionBar?.title = categoriaNombre

        // Encontrar el RecyclerView en el layout
        val productosRecyclerView = findViewById<RecyclerView>(R.id.productosRecyclerView)
        productosRecyclerView.layoutManager = LinearLayoutManager(this)

        // Verificar si se recibieron productos
        if (productos != null) {
            // Crear un adaptador para la lista de productos
            val adapter = ProductoAdapter(productos) { producto ->
                // Aquí puedes manejar el clic en un producto individual
                // Por ejemplo, iniciar la actividad VerProductoActivity y pasar los datos del producto
                val intent = Intent(this, VerProductoActivity::class.java)
                // intent.putExtra("productoId", producto.id) // Pasar el ID del producto
                startActivity(intent)
            }
            // Asignar el adaptador al RecyclerView
            productosRecyclerView.adapter = adapter
        } else {
            // Manejar el caso en que no se recibieron productos (opcional)
            // Por ejemplo, mostrar un mensaje de error
        }
    }
}