package com.example.cloninstagram

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleRecycleView(){
    val Mylist = listOf("Spiderman", "Batman", "Ironman")
    LazyColumn(){
        item { Text(text = "Header") }
        items(Mylist){
            Text(text = "$it")
        }
        item { Text(text = "Footer") }
    }
}