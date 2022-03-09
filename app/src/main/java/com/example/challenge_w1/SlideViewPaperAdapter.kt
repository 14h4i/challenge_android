package com.example.challenge_w1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SlideViewPaperAdapter(context: Context) : PagerAdapter() {

    var context: Context = context

    override fun getCount(): Int {
       return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.slide_screen, container, false)


        val logo = view.findViewById<ImageView>(R.id.logo)
        val slid = view.findViewById<ImageView>(R.id.slid)
        val obTitle = view.findViewById<TextView>(R.id.obTitle)
        val desc = view.findViewById<TextView>(R.id.desc)

        val button =view.findViewById<FloatingActionButton>(R.id.buttonNext)
        button.setOnClickListener{
           var intent:Intent = Intent(context,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }

        when(position){
            0 ->{
                logo.setImageResource(R.drawable.logo_1)
                slid.setImageResource(R.drawable.slide_1)
                obTitle.setText(R.string.title_1)
                desc.setText(R.string.desc_1)
            }
            1 ->{
                logo.setImageResource(R.drawable.logo_2)
                slid.setImageResource(R.drawable.slide_2)
                obTitle.setText(R.string.title_2)
                desc.setText(R.string.desc_2)
            }
            2 ->{
                logo.setImageResource(R.drawable.logo_3)
                slid.setImageResource(R.drawable.slide_3)
                obTitle.setText(R.string.title_3)
                desc.setText(R.string.desc_3)
            }
        }


        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}