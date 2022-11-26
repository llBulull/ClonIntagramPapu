package com.example.cloninstagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cloninstagram.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase):ViewModel() {


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable:LiveData<Boolean> = _isLoginEnable

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
        //loginUseCase("", "")
    }

    fun enableLogin(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                password.length>7

    }

    fun onLoginSelected(){
    viewModelScope.launch {
        val result = loginUseCase()
        _isLoading.value=true
        if (result){
            Log.i("msg", "MESSAGE Ok")
        }else{
            Log.i("MSG", "MESSAGE FAIL")
        }

        _isLoading.value=false
        _isLoading.value=true


    }

    }



}

