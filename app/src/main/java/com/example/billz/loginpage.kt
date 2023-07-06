package com.example.billz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.billz.databinding.ActivityLoginpageBinding

class loginpage : AppCompatActivity() {
    lateinit var binding: ActivityLoginpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginpageBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_loginpage)
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        binding.textView3.setOnClickListener {
            validatelogin()
            clearErrors()
        }

    }

    fun validatelogin(){
        val x =binding.etemail.text.toString()
        val y=binding.etpasssword.text.toString()
        var error = false

        if (x.isEmpty()){
            binding.tilemail.error = "Email Address is Required"
            error= true
        }
        if (y.isBlank()){
            binding.tilpasssword.error = "Wrong password"
        }
        if (!error){
            val intent = Intent(this,loginpage::class.java)
            startActivity(intent)
            Toast.makeText(this,"LogIn successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
    fun clearErrors(){
        binding.tilemail.error = null
        binding.tilpasssword.error = null
    }
}