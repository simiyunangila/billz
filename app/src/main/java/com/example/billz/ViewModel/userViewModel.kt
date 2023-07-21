package com.example.billz.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.billz.Repository.UserRepository
import com.example.billz.model.LoginRequest
import com.example.billz.model.LoginResponse
import com.example.billz.model.RegisterRequest
import com.example.billz.model.registerResponse
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepo = UserRepository()
    val regLiveData = MutableLiveData<registerResponse>()
    val logLiveData = MutableLiveData<LoginResponse>()
    val errLiveData = MutableLiveData<String>()

    fun registerUser( registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response = userRepo.registerUser(registerRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = userRepo.loginUser(loginRequest)
            if (response.isSuccessful){
                logLiveData.postValue(response.body())
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }

        }
    }
}

