package com.example.sampleviewpager2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleviewpager2.R
import com.example.sampleviewpager2.modal.OBModal
import kotlinx.android.synthetic.main.item_layout.view.*

class OBAdapter(private var dataSheets: ArrayList<OBModal>): RecyclerView.Adapter<OBAdapter.OBHolder>()
{
    inner class OBHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val image: AppCompatImageView = view.findViewById(R.id.item_image)
        val title: TextView = view.findViewById(R.id.text_title)
        val desc: TextView = view.findViewById(R.id.text_desc)

        fun bind(modal: OBModal)
        {
            image.setImageResource(modal.image)
            title.text = modal.title
            desc.text = modal.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OBHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        val inflaterView = layoutInflater.inflate(R.layout.item_layout, parent, false)

        return OBHolder(inflaterView)
    }

    override fun onBindViewHolder(holder: OBHolder, position: Int)
    {
        holder.bind(dataSheets[position])
    }

    override fun getItemCount(): Int = dataSheets.size
}