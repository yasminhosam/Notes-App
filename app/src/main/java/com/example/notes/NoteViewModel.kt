package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class NoteViewModel(app:Application):AndroidViewModel(app) {
    private val db=RoomDBHelper.getInstance(app)

    fun upsert(n:Note)=db.dao.upsertNote(n)
    fun delete(n:Note)=db.dao.deleteNote(n)
    fun getAllNotes()=db.dao.getNotes()
}