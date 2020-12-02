package com.example.testmotionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.testmotionlayout.databinding.ItemChildSliderBinding


class SliderAdapter(private val items: List<String>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = items[position]
        val binding = ItemChildSliderBinding.inflate(LayoutInflater.from(container.context))
        val view = binding.root
        binding.textView.text = item
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = `object` == view

    override fun getCount(): Int = items.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}