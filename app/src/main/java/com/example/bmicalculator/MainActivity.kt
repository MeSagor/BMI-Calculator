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
                Toast.makeText(this, "please input data,cannot be blank", Toast.LENGTH_LONG).show()
                textView.setText("").toString()
            } else {
                val weight = w.toInt()
                val height: Double = h.toInt() / 100.0
                val bmi: Double = weight / (height * height)
                textView.setText("Your BMI: $bmi").toString()
            }
        }
    }
}