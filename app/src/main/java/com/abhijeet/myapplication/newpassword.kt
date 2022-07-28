package com.abhijeet.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.abhijeet.myapplication.databinding.ActivityNewpasswordBinding

class newpassword : AppCompatActivity() {
    lateinit var binding: ActivityNewpasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNewpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.etnewpass.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?:0)<6){
                binding.etnewpass.error=resources.getString(R.string.password_limit)
            }else{
                binding.etnewpass.error=null
            }
        }
        binding.etconfirmnew.doOnTextChanged { text, start, before, count ->
            if(!(text==binding.etnewpass.text.toString())){
               binding.etconfirmnew.error=resources.getString(R.string.Password_dont_match)
            }else{
                binding.etconfirmnew.error=null
            }
        }
            binding.btndone.setOnClickListener {
            Toast.makeText(this, resources.getString(R.string.password_changed), Toast.LENGTH_SHORT).show()
        }
    }
}