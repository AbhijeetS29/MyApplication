package com.abhijeet.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var ivpic1:ImageView
    lateinit var tvlogin:TextView
    lateinit var etmail:EditText
    lateinit var etPassword:EditText
    lateinit var btnforgot:Button
    lateinit var btnlogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ivpic1=findViewById(R.id.ivpic1)
        tvlogin=findViewById(R.id.tvlogin)
        etmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        btnforgot=findViewById(R.id.btnforgot)
        btnlogin=findViewById(R.id.btnLogin)

        ivpic1.setOnClickListener {
            Toast.makeText(this, "Login Page", Toast.LENGTH_SHORT).show()
        }
        btnforgot.setOnClickListener {
            var intent = Intent(this,MainActivity3::class.java)
            intent.putExtra("email",etmail.text.toString())
        }
        btnlogin.setOnClickListener {
            etmail.text.clear()
            etPassword.text.clear()

            var email =etmail.text.toString()
            var password=etPassword.text.toString()

            if(email.isNullOrEmpty()) {
                etmail.error = resources.getString(R.string.Enter_your_name)
                etmail.requestFocus()
            }
            else if (password.isNullOrEmpty()) {
                etPassword.error = resources.getString(R.string.Enter_your_Password)
                etPassword.requestFocus()
            }
            else{
                Toast.makeText(this, resources.getString(R.string.Successfully_login), Toast.LENGTH_LONG).show()
                var intent=Intent(this,MainActivity2::class.java)
                startActivity(intent)
                finish()

            }
        }


    }
}