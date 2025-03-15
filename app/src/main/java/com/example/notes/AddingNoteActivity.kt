package com.example.notes

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notes.databinding.ActivityAddingNoteBinding
import com.example.notes.databinding.ActivityMainBinding

class AddingNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityAddingNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viewModel= ViewModelProvider(this)[NoteViewModel::class.java]

        binding.saveBtn.setOnClickListener {
            val details=binding.noteEt.text.toString()
            val n=Note(details=details)
            viewModel.upsert(n)
            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()
            binding.noteEt.text.clear()
        }
    }
}