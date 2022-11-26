package com.example.cloninstagram.login.domain

import com.example.cloninstagram.login.data.LoginRespository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val respository: LoginRespository) {
    //private val respository = LoginRespository()
    suspend operator fun invoke():Boolean{
        return respository.doLogin()
    }
}