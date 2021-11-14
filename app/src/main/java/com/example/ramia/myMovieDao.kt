package com.example.ramia

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface myMovieDao {

    @Query("SELECT * FROM myMovie  ORDER BY id ASC")
    fun getAll(): LiveData<MutableList<myMovie>>

    @Insert
    fun insert(item: myMovie)

    @Delete
    fun Delete(item: myMovie)

    @Update
    fun Update(item: myMovie)




}