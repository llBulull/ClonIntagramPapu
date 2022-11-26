package com.example.cloninstagram

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cloninstagram.model.Routes

@Composable
fun Screen_First(navigationController: NavHostController) {
    Box(modifier = Modifier
        .clickable { navigationController.navigate(Routes.Screen_2.routes) }
        .fillMaxSize()
        .fillMaxWidth()
        .background(Color(0xFF154499))){
        Text(text = "This is the first screen", color = Color(0xFFFFFFFF), fontSize = 24.sp)
    }
}

@Composable
fun Screen_Second(navigationController: NavHostController) {
    Box(modifier = Modifier
        .clickable { navigationController.navigate(Routes.Screen_3.routes) }
        .fillMaxSize()
        .fillMaxWidth()
        .background(Color(0xFF154477D))){
        Text(text = "This is the second screen", color = Color(0xFFFFFFFF), fontSize = 24.sp)
    }
}

@Composable
fun Screen_Third(navigationController: NavHostController) {
    Box(modifier = Modifier
        .clickable { navigationController.navigate("Screen_4/1999") }
        .fillMaxSize()
        .fillMaxWidth()
        .background(Color(0xFF154444))){
        Text(text = "This is the third screen", color = Color(0xFFFFFFFF), fontSize = 24.sp)
    }
}

@Composable
fun Screen_Quarter(navigationController: NavHostController, name:Int){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF154411))){
        Text(text = "My year of birth is: $name", color = Color(0xFFFFFFFF), fontSize = 24.sp)
}
}