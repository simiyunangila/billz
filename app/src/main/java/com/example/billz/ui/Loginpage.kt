package com.example.billz.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.billz.R
import com.example.billz.ViewModel.UserViewModel
import com.example.billz.databinding.ActivityLoginpageBinding
import com.example.billz.model.LoginRequest
import com.example.billz.model.LoginResponse
import com.example.billz.model.RegisterRequest
import com.example.billz.utils.Constant

class loginpage : AppCompatActivity() {
    lateinit var binding: ActivityLoginpageBinding
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginpageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.button2.setOnClickListener {
            validatelogin()

        }
        userViewModel.errLiveData.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            binding.pBar.visibility = View.GONE
        })
        userViewModel.logLiveData.observe(this, Observer { logResponse ->
            persistLogin(logResponse)
            binding.pBar.visibility = View.GONE
            Toast.makeText(this, logResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, homepage::class.java))
            finish()

        })


    }

    fun validatelogin(){

        clearErrors()

        val email =binding.etemail.text.toString()
        val password=binding.etpasssword.text.toString()
        var error = false

        if (email.isEmpty()){
            error= true
            binding.tilemail1.error = "Email Address is Required"

        }
        if (password.isBlank()){
            error= true
            binding.tilpasssword.error = "Wrong password"
        }

        if (!error) {
            val loginRequest = LoginRequest(
                email = email,
                password = password

            )
           binding.pBar.visibility = View.VISIBLE
            userViewModel.loginUser(loginRequest )

        }
    }
    fun clearErrors(){
        binding.tilemail1.error = null
        binding.tilpasssword.error = null
   }

    fun persistLogin(loginResponse: LoginResponse){
        val sharedPrefs = getSharedPreferences(Constant.PREFS,Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString(Constant.USER_ID,loginResponse.user_id)
        editor.putString(Constant.ACCESS_TOKEN,loginResponse.access_token)
        editor.apply()
    }
}