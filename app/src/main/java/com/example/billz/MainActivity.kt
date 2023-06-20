package com.example.billz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.billz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        super.onResume()
        setContentView(binding.root)
        binding.button.setOnClickListener {
            validateregdetails()
            clearErrors()
        }
    }

    fun validateregdetails() {
        val name1 = binding.etname.text.toString()
        val name2 = binding.etusername.text.toString()
        val name3 = binding.etnumber.text.toString()
        val name4 = binding.etpassword.text.toString()
        val name5 = binding.etconfpassword.text.toString()

        var error = false

        if (name1.isEmpty()) {
            binding.tilname.error = " Name required"
            error = true
        }
        if (name2.isEmpty()) {
            binding.tilusername.error = " UserName required"
            error = true
        }
        if (name3.isEmpty()) {
            binding.tilnumber.error = " Phone number required"
            error = true
        }
        if (name4.isEmpty()) {
            binding.tilpassword.error = " Create password"
            error = true
        }
        if (name5 != name4) {
            binding.tilconfpassword.error = " Wrong password"
            error = true
        }
        if (!error) {
         val y = Intent(this,loginpage::class.java)
        startActivity(y)
            Toast.makeText(this, "Registration is complete", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun clearErrors() {
        binding.tilname.error = null
        binding.tilusername.error = null
        binding.tilnumber.error = null
        binding.tilpassword.error = null
        binding.tilconfpassword.error = null

    }
}


