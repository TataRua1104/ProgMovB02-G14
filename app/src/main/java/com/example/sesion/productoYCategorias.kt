package com.example.sesion

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    @DrawableRes val imagenResId: Int // ID del recurso de la imagen (en drawable)
    // Puedes añadir más propiedades como descripción, etc.
) : Serializable

data class Categoria(
    val nombre: String,
    val productos: List<Producto>
)
