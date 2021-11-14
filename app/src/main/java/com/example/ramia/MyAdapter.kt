package com.example.ramia

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.ramia.MainActivity
import com.example.ramia.R
import kotlinx.android.synthetic.main.cell.view.*
import kotlinx.android.synthetic.main.cell.view.*
import kotlinx.android.synthetic.main.cell2.view.*

class MyAdapter(val activity: allvi,var item:MutableList<myMovie>):RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {
    var TAG = "MyAdapter"

    class ItemViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            return ItemViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.cell, parent, false)
            )

    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyAdapter.ItemViewHolder, position: Int) {
        var items = item[position]
        holder.itemView.apply {
                button2.text = items.name
                button2.setOnClickListener {
                myMovieDatabase.getInstance(context).myMovieDao().insert(items)

        }}
    }

    fun update(uu:MutableList<myMovie>){
        this.item = uu
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = item.size
}