package com.example.ejercicios

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentNameInput = findViewById<EditText>(R.id.studentNameInput)
        val grade1Input = findViewById<EditText>(R.id.grade1Input)
        val grade2Input = findViewById<EditText>(R.id.grade2Input)
        val grade3Input = findViewById<EditText>(R.id.grade3Input)
        val grade4Input = findViewById<EditText>(R.id.grade4Input)
        val grade5Input = findViewById<EditText>(R.id.grade5Input)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val name = studentNameInput.text.toString().trim()
            val grade1 = grade1Input.text.toString().toDoubleOrNull()
            val grade2 = grade2Input.text.toString().toDoubleOrNull()
            val grade3 = grade3Input.text.toString().toDoubleOrNull()
            val grade4 = grade4Input.text.toString().toDoubleOrNull()
            val grade5 = grade5Input.text.toString().toDoubleOrNull()

            if (name.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese el nombre del estudiante.", Toast.LENGTH_SHORT).show()
            } else if (grade1 == null || grade2 == null || grade3 == null || grade4 == null || grade5 == null) {
                Toast.makeText(this, "Por favor, ingrese todas las notas correctamente.", Toast.LENGTH_SHORT).show()
            } else if (grade1 !in 0.0..10.0 || grade2 !in 0.0..10.0 || grade3 !in 0.0..10.0 || grade4 !in 0.0..10.0 || grade5 !in 0.0..10.0) {
                Toast.makeText(this, "Las notas deben estar entre 0 y 10.", Toast.LENGTH_SHORT).show()
            } else {
                val finalGrade = grade1 * 0.15 + grade2 * 0.15 + grade3 * 0.20 + grade4 * 0.25 + grade5 * 0.25
                val status = if (finalGrade >= 5.0) "Aprobado" else "Reprobado"
                resultTextView.text = "Estudiante: $name\nNota Final: %.2f\nEstado: $status".format(finalGrade)
            }
        }
    }
}
