package com.example.billz.ui

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.billz.R
import com.example.billz.ViewModel.UserViewModel
import com.example.billz.databinding.ActivityMainBinding
import com.example.billz.model.RegisterRequest


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)
        userViewModel.errLiveData.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
            binding.pbreg.visibility = View.GONE
        })
        userViewModel.regLiveData.observe(this, Observer { regResponse ->
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, loginpage::class.java))
            binding.pbreg.visibility = View.GONE
        })
      binding.button.setOnClickListener {
          validateregdetails()
      }
//            startActivity(Intent(this, loginpage::class.java))





        }
//    }

    fun validateregdetails() {

        clearErrors()
        val name = binding.etname.text.toString()
        val lastname = binding.etlastname.text.toString()
        val phoneNumber= binding.etnumber.text.toString()
        val email = binding.etmail1.text.toString()
        val password = binding.etpassword.text.toString()
        val confPassword = binding.etconfpass.text.toString()

        var error = false


        if (name.isBlank()) {
            error = true
            binding.tilname.error = " Name required"

        }
        if (lastname.isBlank()) {
            error = true
            binding.tillastname.error = " UserName required"

        }
        if (phoneNumber.isBlank()) {
            error = true
            binding.tilnumber.error = " Phone number required"

        }
        if (email.isBlank()) {
            error = true
            binding.tilemail1.error = " Create password"

        }
        if (password.isBlank()) {
            error = true
            binding.tilpassword.error = " Invalid password"

        }
        if (!password.equals(confPassword)) {
            error = true
            binding.tilconfpass.error = " PasswordWord does not match"

        }
        if (!error) {
            val registerRequest =RegisterRequest(
                firstName =name,
                lastName = lastname,
                email = email,
                password = password,
                phoneNumber = phoneNumber

            )
            binding.pbreg.visibility = View.VISIBLE
           userViewModel.registerUser(registerRequest)

//            val intent = Intent(this, loginpage::class.java)
//            startActivity(intent)

        }
    }

    fun clearErrors() {
        binding.tilname.error = null
        binding.tillastname.error = null
        binding.tilnumber.error = null
        binding.tilpassword.error = null
        binding.tilconfpass.error = null
    }
}


