package com.abhijeet.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class mainactivity2 : AppCompatActivity() {
    var password = ""
    lateinit var etforgotprocess:EditText
    lateinit var btnnext:Button
    lateinit var tvanotherway:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        etforgotprocess=findViewById(R.id.etforgotprocess)
        btnnext=findViewById(R.id.btnnext)
        tvanotherway=findViewById(R.id.tvanotherway)
        intent?.let {
           password = it.getStringExtra("password") as String
        }?:kotlin.run {  }
//        etforgotprocess.doOnTextChanged { text, start, before, count ->
//            if(!(text==etpassword.text.tostring))
//        }

        tvanotherway.setOnClickListener {
            var intent = Intent(this,mainactivity3::class.java)
            startActivity(intent)
        }
        btnnext.setOnClickListener {
            var intent = Intent(this,newpassword::class.java)
            startActivity(intent)
        }

    }
}