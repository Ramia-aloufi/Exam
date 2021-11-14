package com.example.ramia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import org.json.JSONArray
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var rv :RecyclerView
    lateinit var search : Button
    lateinit var et :EditText
    lateinit var al:MutableList<myMovie>

    var url = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)
        search = findViewById(R.id.button)
        et = findViewById(R.id.editTextTextPersonName)
         al = arrayListOf()
        search.setOnClickListener {
            var searchFor = et.text.toString()
            url = "https://api.tvmaze.com/search/shows?q=$searchFor"
            requestAPI()
            et.text.clear()
        }

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
            for (i in 0 until json.length() ) {
                val name = json.getJSONObject(i).getJSONObject("show").getString("name").toString()
                val languge = json.getJSONObject(i).getJSONObject("show").getString("language").toString()
                try {
                     summary = json.getJSONObject(i).getJSONObject("show").getString("summary").toString()
                }catch (e:Exception){
                    summary = ""
                }
                try {
                    img = json.getJSONObject(i).getJSONObject("show").getJSONObject("image")
                        .getString("original").toString()
                }catch (e:Exception){
                    img = "empty"
                }
                al.add(myMovie(null,img,name,summary,languge))
            }
            rv.adapter?.notifyDataSetChanged()

        }



    }
}



