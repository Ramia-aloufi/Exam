package com.example.ramia


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Entity(tableName = "myMovie")
data class myMovie(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id")  var id :Int?, // this is how can include id if needed
    @ColumnInfo(name = "img") val img: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "summary") val summary: String,
    @ColumnInfo(name = "language") val language: String)



