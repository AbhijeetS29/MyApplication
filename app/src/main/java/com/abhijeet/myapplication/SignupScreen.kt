package com.abhijeet.myapplication

import android.media.MediaCodec
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged

class SignupScreen : AppCompatActivity() {
    lateinit var etFirstname :EditText
    lateinit var etLastname:EditText
    lateinit var etphonenumber:EditText
    lateinit var etEmail1:EditText
    lateinit var etpassword1:EditText
    lateinit var etpassword2:EditText
    lateinit var rdmale:RadioButton
    lateinit var rdfemale:RadioButton
    lateinit var rdother:RadioButton
    lateinit var etdescription: EditText
    lateinit var btnsignup:Button
    lateinit var rggender:RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_screen)
        etFirstname= findViewById(R.id.etFirstname)
        etLastname= findViewById(R.id.etlastname)
        etphonenumber=findViewById(R.id.etPhonenumber)
        etEmail1= findViewById(R.id.etEmail1)
        etpassword1= findViewById(R.id.etPassword1)
        etpassword2= findViewById(R.id.etPassword2)
        rdmale= findViewById(R.id.rdmale)
        rdfemale= findViewById(R.id.rdfemale)
        etdescription= findViewById(R.id.etdescription)
        btnsignup= findViewById(R.id.btnsignup)
        rdother=findViewById(R.id.rdother)
        rggender=findViewById(R.id.rggender)
        etphonenumber.doOnTextChanged { text,_,_, _ ->
            if((text?.length ?:0)<10)
                Toast.makeText(this, resources.getString(R.string.Phonenumber_limit), Toast.LENGTH_LONG  ).show()
        }

        etEmail1.doOnTextChanged { text, start, before, count ->

            if (!(Patterns.EMAIL_ADDRESS.matcher(etEmail1.text.toString()).matches())) {
                    etEmail1.error=resources.getString(R.string.Email_wrong)
            }
        }
        etpassword1.doOnTextChanged { text, start, before, count ->
            if((text?.length ?:0) <6){
                Toast.makeText(this, resources.getString(R.string.password_limit), Toast.LENGTH_LONG).show()
        }
            else{
                Toast.makeText(this, resources.getString(R.string.done), Toast.LENGTH_SHORT).show()
            }
        }
        etpassword2.doOnTextChanged { text, start, before, count ->
            if(!(text==etpassword1.text.toString())){
                etpassword2.error=resources.getString(R.string.Password_dont_match)

            }
            else{
                etpassword2.error=null
            }
        }
        rggender.setOnCheckedChangeListener { radioGroup, id ->
            when(id){
                R.id.rdother->{
                    etdescription.visibility=View.VISIBLE
                }else ->{
                    etdescription.visibility=View.GONE

            }
        }
        }

        btnsignup.setOnClickListener {
            Toast.makeText(this, resources.getString(R.string.signup_succesfully), Toast.LENGTH_LONG).show()
        }
    }
}