package com.example.testmotionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testmotionlayout.databinding.ItemGrid2Binding
import com.example.testmotionlayout.databinding.ItemGrid4Binding
import com.example.testmotionlayout.databinding.ItemSliderBinding

class MainAdapter(
    private val items: List<MainModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            ItemType.GRID_4 -> 0
            ItemType.SLIDER -> 1
            ItemType.GRID_2 -> 2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_4, parent, false)
                Grid4Holder(v)
            }
            1 -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.item_slider, parent, false)
                SliderHolder(v)
            }
            2 -> {
                val v = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_2, parent, false)
                Grid2Holder(v)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is Grid4Holder -> {
                holder.bind(items[position])
            }
            is SliderHolder -> {
                holder.bind(items[position])
            }
            is Grid2Holder -> {
                holder.bind(items[position])
            }
        }
    }

    class Grid4Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemGrid4Binding.bind(itemView)

        fun bind(item: MainModel) {
            binding.recyclerView.apply {
                addItemDecoration(GridItemSpacing(4, 40))
                adapter = Grid4Adapter(item.items)
            }
        }
    }

    class SliderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemSliderBinding.bind(itemView)

        fun bind(item: MainModel) {
            binding.viewPager.adapter = SliderAdapter(item.items)
            binding.viewPager.pageMargin = 40
        }
    }

    class Grid2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemGrid2Binding.bind(itemView)

        fun bind(item: MainModel) {
            binding.recyclerView.apply {
                addItemDecoration(GridItemSpacing(2, 60))
                adapter = Grid2Adapter(item.items)
            }
        }
    }

}