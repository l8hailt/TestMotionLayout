package com.example.testmotionlayout

import android.os.Bundle
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.testmotionlayout.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        val params = motionLayout.layoutParams as FrameLayout.LayoutParams
        params.setMargins(0, getStatusBarHeight(), 0, getNavigationBarHeight())

        val items = mutableListOf<MainModel>()
        val childItems = mutableListOf<String>()
        val childSliderItems = mutableListOf<String>()
        val childGrid2Items = mutableListOf<String>()
        for (i in 0..20) {
            childItems.add(i.toString())
        }
        for (i in 0..3) {
            childSliderItems.add(i.toString())
        }
        for (i in 0..21) {
            childGrid2Items.add(i.toString())
        }
        items.add(MainModel(childItems, ItemType.GRID_4))
        items.add(MainModel(childSliderItems, ItemType.SLIDER))
        items.add(MainModel(childGrid2Items, ItemType.GRID_2))
        binding.recyclerView.adapter = MainAdapter(items)

    }

    private fun getStatusBarHeight(): Int {
        val resources = resources
        val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            resources.getDimensionPixelSize(resourceId)
        } else 0
    }

    private fun getNavigationBarHeight(): Int {
        val resources = resources
        val resourceId: Int = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            resources.getDimensionPixelSize(resourceId)
        } else 0
    }
}