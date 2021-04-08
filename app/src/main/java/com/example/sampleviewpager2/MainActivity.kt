package com.example.sampleviewpager2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager2.widget.ViewPager2
import com.example.sampleviewpager2.adapter.OBAdapter
import com.example.sampleviewpager2.modal.OBModal
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity()
{
    //
    private var adapter: OBAdapter? = null

    //
    private var list: ArrayList<OBModal>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 
        list?.add(OBModal(
            R.drawable.first, "First Sample", "This is Sample Description Image 1"
        ))

        list?.add(OBModal(
            R.drawable.second, "Second Sample", "This is Sample Description Image 2"
        ))

        list?.add(OBModal(
            R.drawable.third, "Third Sample", "This is Sample Description Image 3"
        ))

        //
        adapter = list?.let { OBAdapter(it) }
        val viewPager: ViewPager2 = findViewById(R.id.view_pager_2)
        viewPager.adapter = adapter

        //
        val pagerIndicator: WormDotsIndicator = findViewById(R.id.indicator_pager)
        pagerIndicator.setViewPager2(viewPager)

        //
        val btnNext: AppCompatButton = findViewById(R.id.button_pager)
        btnNext.setOnClickListener {
            if (viewPager.currentItem + 1 < adapter!!.itemCount)
            {
                viewPager.currentItem += 1
            }

            else
            {
                val intentHome = Intent(this, HomeActivity::class.java)
                startActivity(intentHome)
            }
        }

        //
        val btnSkip: TextView = findViewById(R.id.skip_pager)
        btnSkip.setOnClickListener {
            val intentSkip = Intent(this, HomeActivity::class.java)
            startActivity(intentSkip)
        }
    }
}