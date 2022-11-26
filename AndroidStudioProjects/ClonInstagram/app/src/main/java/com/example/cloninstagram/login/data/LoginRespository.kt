package com.example.cloninstagram.login.data

import javax.inject.Inject

class LoginRespository @Inject constructor(private val api:LoginService) {
    //private val api = LoginService()
    suspend fun doLogin():Boolean{
        return api.doLogin()
    }
}