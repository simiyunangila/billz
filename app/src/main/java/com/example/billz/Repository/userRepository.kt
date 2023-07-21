package com.example.billz.Repository

import com.example.billz.api.apiClient
import com.example.billz.api.ApiInterface
import com.example.billz.model.LoginRequest
import com.example.billz.model.LoginResponse
import com.example.billz.model.RegisterRequest
import com.example.billz.model.registerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiclient =apiClient.buildClient(ApiInterface::class.java)

   suspend fun registerUser(registerRequest: RegisterRequest):Response<registerResponse>{
        return withContext(Dispatchers.IO){
            apiclient.registerUser(registerRequest)
        }

    }
    suspend  fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>{
        return withContext(Dispatchers.IO){
            apiclient.loginUser(loginRequest)
        }
    }

}


