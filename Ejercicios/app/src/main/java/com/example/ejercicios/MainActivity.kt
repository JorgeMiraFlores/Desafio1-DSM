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

        val employeeNameInput = findViewById<EditText>(R.id.employeeNameInput)
        val baseSalaryInput = findViewById<EditText>(R.id.baseSalaryInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val name = employeeNameInput.text.toString()
            val baseSalary = baseSalaryInput.text.toString().toDoubleOrNull()

            if (name.isBlank() || baseSalary == null) {
                Toast.makeText(this, "Por favor, ingrese todos los datos correctamente.", Toast.LENGTH_SHORT).show()
            } else {
                val afp = baseSalary * 0.0725
                val isss = baseSalary * 0.03
                val renta = calculateRenta(baseSalary)

                val netSalary = baseSalary - afp - isss - renta

                resultTextView.text = """
                    Empleado: $name
                    Salario Base: $${"%.2f".format(baseSalary)}
                    AFP (7.25%): $${"%.2f".format(afp)}
                    ISSS (3%): $${"%.2f".format(isss)}
                    Renta: $${"%.2f".format(renta)}
                    Salario Neto: $${"%.2f".format(netSalary)}
                """.trimIndent()
            }
        }
    }

    private fun calculateRenta(salary: Double): Double {
        return when {
            salary <= 472.00 -> 0.0
            salary <= 895.24 -> (salary - 472.00) * 0.10 + 17.67
            salary <= 2038.10 -> (salary - 895.24) * 0.20 + 60.00
            else -> (salary - 2038.10) * 0.30 + 288.57
        }
    }
}
