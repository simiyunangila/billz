package com.example.billz

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
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
    }
}