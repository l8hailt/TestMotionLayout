package com.example.testmotionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testmotionlayout.databinding.ItemChildGrid2Binding

class Grid2Adapter(
    private val items: List<String>
) : RecyclerView.Adapter<Grid2Adapter.GridHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_child_grid_2, parent, false)
        return GridHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: GridHolder, position: Int) = holder.bind(items[position])

    class GridHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemChildGrid2Binding.bind(itemView)

        fun bind(item: String) {
            println(item)
            binding.textView.text = "Item $item"
        }
    }
}