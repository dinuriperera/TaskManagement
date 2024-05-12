package com.example.medicalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.medicalapp.databinding.ActivityAddPrescriptionBinding
import com.example.medicalapp.databinding.ActivityMainBinding

class AddPrescriptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPrescriptionBinding
    private lateinit var db: NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPrescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contentText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Prescription Saved", Toast.LENGTH_SHORT).show()
        }    }
}