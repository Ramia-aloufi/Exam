package com.example.ramia

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [myMovie::class],version = 1,exportSchema = false)
abstract class myMovieDatabase:RoomDatabase() {
    abstract fun myMovieDao(): myMovieDao;
    companion object{
        var instance:myMovieDatabase?=null;
        fun getInstance(ctx: Context):myMovieDatabase{
            if(instance!=null)
            {
                return  instance as myMovieDatabase;
            }
            instance = Room.databaseBuilder(ctx,myMovieDatabase::class.java,"ram11111").run { allowMainThreadQueries() }.build()
            return instance as myMovieDatabase;
        }
    }
}