package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModel= ViewModelProvider(this)[NoteViewModel::class.java]

        viewModel.getAllNotes().observe(this){notes->
            val details=notes.map{it.details}
            val adaptetr=ArrayAdapter(this,android.R.layout.simple_list_item_1,details)
            binding.notesList.adapter=adaptetr

            binding.notesList.setOnItemClickListener { parent, view, position, id ->
                val i =Intent(this,EditingNoteActivity::class.java)
                i.putExtra("note",notes[position])
                startActivity(i)
            }
        }
        binding.addFab.setOnClickListener{
            startActivity(Intent(this,AddingNoteActivity::class.java))
        }
    }

}