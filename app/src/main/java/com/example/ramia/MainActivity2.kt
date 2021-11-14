package com.example.ramia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    lateinit var rv2: RecyclerView
    lateinit var al: MutableList<myMovie>
    lateinit var al2: ArrayList<myMovie>

    //    lateinit var mainViewModel: VM
    lateinit var rv2adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
//        al = arrayListOf()
//        al2 = arrayListOf()
//        rv2 = findViewById(R.id.rv2)
//        getdata()
//
////        mainViewModel = ViewModelProvider(this).get(VM::class.java)
////        mainViewModel.getAll().observe(this,{
////            mov -> rv2adapter.update(mov)
////        })
//        rv2.adapter?.notifyDataSetChanged()
//        rv2adapter = MyAdapter(this, al)
//        rv2.layoutManager = LinearLayoutManager(this)
//
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun del(items: myMovie) {
//        myMovieDatabase.getInstance(this).myMovieDao().Delete(items)
//        getdata()
//    }
//
//
//    fun getdata() {
//        al2.clear()
//        var allMovie = myMovieDatabase.getInstance(this).myMovieDao().getAll()
//        for (i in allMovie) {
//            al2.add(i)
//        }
//        al = al2
//        rv2.adapter = MyAdapter(this, al)
//        rv2.layoutManager = LinearLayoutManager(this)
//        rv2.adapter?.notifyDataSetChanged()
//
//    }

}