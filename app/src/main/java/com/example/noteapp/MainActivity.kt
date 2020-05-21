package com.example.noteapp

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var noteListView: ListView
    val notes: ArrayList<Note> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ListView
        val adapter = Adapter(this, notes)
        noteListView = findViewById(R.id.note_list)
        noteListView.adapter = adapter

        // Add new note
        val addNoteButton = findViewById<Button>(R.id.add_note_btn)
        addNoteButton.setOnClickListener {
            val titleString = title_edt.text.toString()
            val detailString = detail_edt.text.toString()
            notes.add(Note(titleString, detailString))
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "New Note $titleString Added", Toast.LENGTH_LONG).show()
        }
    }
}