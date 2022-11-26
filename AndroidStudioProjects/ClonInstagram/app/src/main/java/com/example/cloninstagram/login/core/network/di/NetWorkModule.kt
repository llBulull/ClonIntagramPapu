package com.example.cloninstagram.login.core.network.di

import com.example.cloninstagram.login.data.LoginClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule {
    @Singleton
    @Provides
    fun providerRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginClient(retrofit: Retrofit):LoginClient{
        return retrofit.create(LoginClient::class.java)
    }
}