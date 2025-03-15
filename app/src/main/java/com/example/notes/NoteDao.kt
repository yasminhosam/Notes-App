package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
@Dao
interface NoteDao {
    @Upsert
    fun upsertNote(n:Note)

    @Delete
    fun deleteNote(n:Note)

    @Query("SELECT * FROM note")
    fun getNotes():LiveData<List<Note>>
}