package com.example.sesion
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductoAdapter(private val productos: List<Producto>, private val onItemClick: (Producto) -> Unit) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreProductoTextView)
        val precioTextView: TextView = itemView.findViewById(R.id.precioProductoTextView)
        val imagenImageView: ImageView = itemView.findViewById(R.id.imagenProductoImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.producto_lista, parent, false) // Crea un layout para cada producto
        return ProductoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.nombreTextView.text = producto.nombre
        holder.precioTextView.text = "$${producto.precio}"
        holder.imagenImageView.setImageResource(producto.imagenResId)
        holder.itemView.setOnClickListener {
            onItemClick(producto)
        }
    }

    override fun getItemCount() = productos.size
}