package com.example.ramia

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cell.view.*
import kotlinx.android.synthetic.main.cell2.view.*

class MyAdapter2(val activity: myvi): RecyclerView.Adapter<MyAdapter2.ItemViewHolder>() {
    var item= mutableListOf<myMovie>()
    var TAG = "MyAdapter2"

    class ItemViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell2, parent, false)
        )
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var items = item[position]
        holder.itemView.apply {

                    textView.text = items.name
                    textView2.text = items.language
                    if (items.img.isEmpty()){
                        imageView.setColorFilter(Color.DKGRAY);

                        imageView.setImageResource(R.drawable.imgg)
                    }else{
                        Glide.with(activity).load(items.img).into(imageView)
                    }
                    imageView2.setOnClickListener {
                        activity.del(items)
                    }
                    ll1.setOnClickListener { Toast.makeText(context,items.summary, Toast.LENGTH_SHORT).show() }
                }

            }


    fun update(uu:MutableList<myMovie>){
        this.item = uu
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = item.size
}