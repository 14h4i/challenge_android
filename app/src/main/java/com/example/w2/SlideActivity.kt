package com.example.w2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.w2.SlideViewPaperAdapter

class SlideActivity : AppCompatActivity() {

    lateinit var viewPaper:ViewPager
    lateinit var adapter: SlideViewPaperAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        viewPaper=findViewById(R.id.viewpaper)
        adapter= SlideViewPaperAdapter(this)
        viewPaper.adapter = adapter

    }
}