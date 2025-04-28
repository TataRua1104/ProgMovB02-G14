package com.example.sesion

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoriaAdapter(private val categorias: List<Categoria>, private val onCategoriaClick: (Categoria) -> Unit) :
    RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>() {

    class CategoriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreCategoriaTextView)
        val productosRecyclerViewHorizontal: RecyclerView = itemView.findViewById(R.id.productosRecyclerViewHorizontal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categoria, parent, false)
        return CategoriaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val categoria = categorias[position]
        holder.nombreTextView.text = categoria.nombre
        holder.itemView.setOnClickListener {
            onCategoriaClick(categoria)
        }

        // Configurar el RecyclerView horizontal de productos
        holder.productosRecyclerViewHorizontal.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = ProductoHorizontalAdapter(categoria.productos)
        holder.productosRecyclerViewHorizontal.adapter = adapter
    }

    override fun getItemCount() = categorias.size
}