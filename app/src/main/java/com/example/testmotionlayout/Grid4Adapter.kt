package com.example.testmotionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testmotionlayout.databinding.ItemChildGrid4Binding

class Grid4Adapter(
    private val items: List<String>
) : RecyclerView.Adapter<Grid4Adapter.GridHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_child_grid_4, parent, false)
        return GridHolder(v)
    }

    override fun getItemCount(): Int = items.size.takeIf { it < 12 } ?: 12

    override fun onBindViewHolder(holder: GridHolder, position: Int) = holder.bind(items[position], position)

    inner class GridHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemChildGrid4Binding.bind(itemView)

        fun bind(item: String, position: Int) {
            if (items.size > 12) {
                if (position >= 11) {
                    binding.textView.text = "+${items.size - 11}"
                } else {
                    binding.textView.text = "Item $item"
                }
            } else {
                binding.textView.text = "Item $item"
            }
        }
    }
}