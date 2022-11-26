package com.example.cloninstagram.model

import androidx.annotation.DrawableRes

data class SuperHeros(
    var superHeroName:String,
    var realName:String,
    var publiser:String,
    @DrawableRes var photo:Int
)
