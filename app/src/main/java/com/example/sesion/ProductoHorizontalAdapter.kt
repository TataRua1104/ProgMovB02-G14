package com.example.sesion

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductoHorizontalAdapter(private val productos: List<Producto>) :
    RecyclerView.Adapter<ProductoHorizontalAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagenProducto: ImageView = itemView.findViewById(R.id.imagenProductoImageView)
        val nombreProducto: TextView = itemView.findViewById(R.id.nombreProductoTextView)
        val precioProducto: TextView = itemView.findViewById(R.id.precioProductoTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.producto_lista, parent, false)
        return ProductoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.nombreProducto.text = producto.nombre
        holder.precioProducto.text = "$${producto.precio}"
        holder.imagenProducto.setImageResource(producto.imagenResId)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, VerProductoActivity::class.java)
            intent.putExtra("producto", producto)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = productos.size
}