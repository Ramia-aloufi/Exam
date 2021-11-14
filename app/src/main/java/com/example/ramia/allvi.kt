package com.example.ramia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import org.json.JSONArray
import java.lang.Exception
import java.net.URL

class allvi : Fragment() {
    lateinit var rv : RecyclerView
    lateinit var search : Button
    lateinit var et : EditText
    lateinit var al:MutableList<myMovie>
    var url = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view1 =  inflater.inflate(R.layout.fragment_allvi, container, false)
        rv = view1.findViewById(R.id.rv)
        search = view1.findViewById(R.id.button)
        et = view1.findViewById(R.id.editTextTextPersonName)
        al = arrayListOf()
        search.setOnClickListener {
            al.clear()
            var searchFor = et.text.toString()
            url = "https://api.tvmaze.com/search/shows?q=$searchFor"
            requestAPI()
            et.text.clear()}

        return view1
    }

    fun requestAPI(){
        CoroutineScope(Dispatchers.IO).launch{
            val data = async { CheckURL() }.await()

            if(data.isNotEmpty()){
                bindingToView(data)
            }
        }

    }
    fun CheckURL():String{
        var url = ""
        try {
            url = URL(this.url).readText(Charsets.UTF_8)
        }catch (e: Exception){

        }
        return url
    }

    suspend fun bindingToView(data:String){
        withContext(Dispatchers.Main){
            val json = JSONArray(data)
            var img = ""
            var summary = ""
            var languge = ""
            for (i in 0 until json.length() ) {
                val name = json.getJSONObject(i).getJSONObject("show").getString("name").toString()
                try {
                    languge =json.getJSONObject(i).getJSONObject("show").getString("language").toString()
                }catch(e: Exception){
                    languge = "not Defiend"
                }
                try {
                    summary = json.getJSONObject(i).getJSONObject("show").getString("summary").toString()
                }catch (e: Exception){
                    summary = "empty"
                }
                try {
                    img = json.getJSONObject(i).getJSONObject("show").getJSONObject("image")
                        .getString("original").toString()
                }catch (e: Exception){
                    img = ""
                }
                al.add(myMovie(null,img,name,summary,languge))
            }
            rv.adapter = MyAdapter(this@allvi,al)
            rv.layoutManager = LinearLayoutManager(requireActivity())
            rv.adapter?.notifyDataSetChanged()

        }



    }

}