package com.abhijeet.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

class newpassword : AppCompatActivity() {
    lateinit var etnewpass:EditText
    lateinit var etconfirmnew:EditText
    lateinit var btndone:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newpassword)
        etnewpass=findViewById(R.id.etnewpass)
        etconfirmnew=findViewById(R.id.etconfirmnew)
        btndone=findViewById(R.id.btndone)


        etnewpass.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?:0)<6){
                etnewpass.error=resources.getString(R.string.password_limit)
            }else{
                etnewpass.error=null
            }
        }
        etconfirmnew.doOnTextChanged { text, start, before, count ->
            if(!(text==etnewpass.text.toString())){
                etconfirmnew.error=resources.getString(R.string.Password_dont_match)
            }else{
                etconfirmnew.error=null
            }
        }
        btndone.setOnClickListener {
            Toast.makeText(this, resources.getString(R.string.password_changed), Toast.LENGTH_SHORT).show()
        }
    }
}