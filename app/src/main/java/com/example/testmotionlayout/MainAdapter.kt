package com.example.testmotionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testmotionlayout.databinding.ItemMainBinding

class MainAdapter(private val items: List<String>) :
    RecyclerView.Adapter<MainAdapter.MainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) = holder.bind(items[position])

    class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemMainBinding.bind(itemView)
//        private val textView: TextView = itemView.findViewById(R.id.textView)

        fun bind(item: String) {
            binding.textView.text = "Item $item"
        }
    }

}