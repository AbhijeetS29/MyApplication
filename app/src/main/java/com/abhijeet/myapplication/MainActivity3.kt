package com.abhijeet.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    var password = ""
    lateinit var etforgotprocess:EditText
    lateinit var btnnext:Button
    lateinit var tvanotherway:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        etforgotprocess=findViewById(R.id.etforgotprocess)
        btnnext=findViewById(R.id.btnnext)
        tvanotherway=findViewById(R.id.tvanotherway)
        intent?.let {
           password = it.getStringExtra("password") as String
        }?:kotlin.run {  }

    }
}