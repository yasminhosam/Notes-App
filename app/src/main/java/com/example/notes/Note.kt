package com.example.notes

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "note")
class Note (
    @ColumnInfo(name = "_id")
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val details:String
):Parcelable