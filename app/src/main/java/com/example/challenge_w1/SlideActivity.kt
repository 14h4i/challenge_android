package com.example.challenge_w1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class SlideActivity : AppCompatActivity() {

    lateinit var viewPaper:ViewPager
    lateinit var adapter:SlideViewPaperAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        viewPaper=findViewById(R.id.viewpaper)
        adapter= SlideViewPaperAdapter(this)
        viewPaper.adapter = adapter

    }
}