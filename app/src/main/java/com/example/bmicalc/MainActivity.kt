package com.example.bmicalc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var bmi:TextView=findViewById(R.id.bmi)
        var weight:EditText=findViewById(R.id.weight)
        var height:EditText=findViewById(R.id.height)
        var btn:Button=findViewById(R.id.btncalc)

        btn.setOnClickListener(){
            val weightval = weight.text.toString().toDoubleOrNull()
            val heightval= height.text.toString().toDoubleOrNull()
            if (weightval != null && heightval != null && heightval > 0) {
                bmi.setText((weightval / (heightval / 100).pow(2) ).toString())
            } else {
                bmi.setText("Please enter valid weight & height")
            }

        }
    }
}