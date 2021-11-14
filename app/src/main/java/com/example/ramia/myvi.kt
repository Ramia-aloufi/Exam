package com.example.ramia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class myvi : Fragment() {
    lateinit var rv2: RecyclerView
    lateinit var al: MutableList<myMovie>
    lateinit var al2: ArrayList<myMovie>
    lateinit var myview:VM
    lateinit var rv2adapter :MyAdapter2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view1 =  inflater.inflate(R.layout.fragment_myvi, container, false)
        al = arrayListOf()
        al2 = arrayListOf()
        rv2 = view1.findViewById(R.id.rv2)
//        getdata()
        rv2adapter = MyAdapter2(this)
        rv2.adapter = rv2adapter
        myview = ViewModelProvider(requireActivity()).get(VM::class.java)
        myview.getAll().observe(requireActivity(),{
            mov -> rv2adapter.update(mov)
        })
        rv2adapter?.notifyDataSetChanged()
        rv2.layoutManager = LinearLayoutManager(requireContext())

        return view1
    }

    fun del(items: myMovie) {
        myMovieDatabase.getInstance(requireContext()).myMovieDao().Delete(items)
//        getdata()
    }


//    fun getdata() {
//        al2.clear()
//        var allMovie = myMovieDatabase.getInstance(requireContext()).myMovieDao().getAll()
//        for (i in allMovie) {
//            al2.add(i)
//        }
//        al = al2
//        rv2.adapter?.notifyDataSetChanged()
//
//    }

}