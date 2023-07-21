package com.example.billz.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    var email:String,
    var password:String,
)
