package com.example.bmicalculator


import android.annotation.SuppressLint
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val editText1 = findViewById<EditText>(R.id.editTextNumber2)
        val editText2 = findViewById<EditText>(R.id.editTextNumber3)

        button.setOnClickListener() {
            val w = editText1.text.toString()
            val h = editText2.text.toString()


            if (w.isBlank() || h.isBlank()) {
                Toast.makeText(this, "Data cannot be blank", Toast.LENGTH_LONG).show()
                textView.setText("").toString()
            } else {
                val weight = w.toInt()
                val intHeight = h.toInt()

                if ((weight in 1000 downTo 1) and (intHeight in 300 downTo 1)) {
                    val height: Double = intHeight / 100.0
                    val unformedBmi: Double = weight / (height * height)
                    val bmi = String.format("%.2f", unformedBmi)
                    textView.setText("Your BMI: $bmi").toString()
                    if (bmi.toDouble() > 100) {
                        Toast.makeText(this, "Are you Alive!", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "Please input valid data", Toast.LENGTH_LONG).show()
                    textView.setText("").toString()
                }
            }
        }
    }
}