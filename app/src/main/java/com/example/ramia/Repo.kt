package com.example.ramia

import android.provider.ContactsContract
import androidx.lifecycle.LiveData

class Repo(val mymoviedao:myMovieDao) {
    val getAll: LiveData<MutableList<myMovie>> = mymoviedao.getAll()

    suspend fun Delete(item: myMovie){
        mymoviedao.Delete(item)
    }

    suspend fun Update(item: myMovie){
        mymoviedao.Update(item)
    }
    suspend fun insert(item: myMovie){
        mymoviedao.insert(item)
    }
}