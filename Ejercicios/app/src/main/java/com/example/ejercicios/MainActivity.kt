package com.example.ejercicios

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operand1Input = findViewById<EditText>(R.id.operand1Input)
        val operand2Input = findViewById<EditText>(R.id.operand2Input)
        val operationSpinner = findViewById<Spinner>(R.id.operationSpinner)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val operand1 = operand1Input.text.toString().toDoubleOrNull()
            val operand2 = operand2Input.text.toString().toDoubleOrNull()
            val operation = operationSpinner.selectedItem.toString()

            if (operand1 == null || operand2 == null) {
                Toast.makeText(this, "Por favor, ingrese ambos operandos.", Toast.LENGTH_SHORT).show()
            } else {
                val result = when (operation) {
                    "Suma" -> operand1 + operand2
                    "Resta" -> operand1 - operand2
                    "Multiplicación" -> operand1 * operand2
                    "División" -> {
                        if (operand2 == 0.0) {
                            Toast.makeText(this, "No se puede dividir entre cero.", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        } else {
                            operand1 / operand2
                        }
                    }
                    else -> 0.0
                }

                resultTextView.text = "Resultado: $result"
            }
        }
    }
}
