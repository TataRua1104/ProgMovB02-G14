package com.example.sesion

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagenResId: Int,
    val videoUrl: String? = null,
    val whatsappUrl: String? = null
) : Serializable

data class Categoria(
    val nombre: String,
    val productos: List<Producto>
)
