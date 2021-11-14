package com.example.ramia

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VM(application: Application): AndroidViewModel(application) {
    private val repository: Repo
    private val notes: LiveData<MutableList<myMovie>>

    init {
        val movieDao = myMovieDatabase.getInstance(application).myMovieDao()
        repository = Repo(movieDao)
        notes = repository.getAll
    }

    fun getAll(): LiveData<MutableList<myMovie>>{
        return notes
    }

    fun insert(movie: myMovie){
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(movie)
        }
    }

    fun update(movie: myMovie){
        CoroutineScope(Dispatchers.IO).launch {
            repository.Update(movie)
        }
    }

    fun delete(movie: myMovie){
        CoroutineScope(Dispatchers.IO).launch {
            repository.Delete(movie)
        }
    }
}