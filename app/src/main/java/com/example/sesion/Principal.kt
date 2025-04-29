package com.example.sesion

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class Principal : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var menuIcon: ImageView

    private val categorias = listOf(
        Categoria(
            nombre = "Zapatos",
            productos = listOf(
                Producto(
                    id = 1,
                    nombre = "Zapato Único",
                    precio = 60.000,
                    imagenResId = R.drawable.zapatos,
                    videoUrl = "https://www.youtube.com/watch?v=axFBq0Ir3KA", // Reemplaza con la URL real
                    whatsappUrl = "https://wa.me/52155XXXXXXXXX" // Reemplaza con el número real con código de país
                ),
                Producto(
                    id = 2,
                    nombre = "Zapato Dama",
                    precio = 30.000,
                    imagenResId = R.drawable.zapa,
                    videoUrl = "https://www.youtube.com/watch?v=YYYYYYYYYYY", // Reemplaza con la URL real
                    whatsappUrl = "https://wa.me/52155YYYYYYYYY" // Reemplaza con el número real con código de país
                ),
                Producto(
                    id = 3,
                    nombre = "Tenis Rosa",
                    precio = 40.000,
                    imagenResId = R.drawable.tenis_rosa
                ),
                Producto(
                    id = 4,
                    nombre = "Zapato Vel",
                    precio = 40.000,
                    imagenResId = R.drawable.tenis_vel
                ),
                Producto(
                    id = 5,
                    nombre = "Tenis Rojo",
                    precio = 55.000,
                    imagenResId = R.drawable.rojo
                ),
                Producto(
                    id = 6,
                    nombre = "Tenis Ame",
                    precio = 66.000,
                    imagenResId = R.drawable.ame

                )
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        menuIcon = findViewById(R.id.menuIcon)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

        menuIcon.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        val categoriasRecyclerView = findViewById<RecyclerView>(R.id.categoriasRecyclerView)
        categoriasRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CategoriaAdapter(categorias) { categoria ->
            // Aquí manejas el clic en la categoría (puedes dejarlo como está o simplificarlo)
            Toast.makeText(this, "Clic en la categoría: ${categoria.nombre}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListaProductosActivity::class.java)
            intent.putExtra("categoriaNombre", categoria.nombre)
            intent.putExtra("productos", ArrayList(categoria.productos))
            startActivity(intent)
        }
        categoriasRecyclerView.adapter = adapter
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_gallery -> {
                Toast.makeText(this, "Galería", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_slideshow -> {
                Toast.makeText(this, "Presentación", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}