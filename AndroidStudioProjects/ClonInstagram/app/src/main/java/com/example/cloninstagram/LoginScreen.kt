package com.example.cloninstagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cloninstagram.ui.theme.ClonInstagramTheme

@Composable
fun LoginScreen(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp) ){
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }

}

@Composable
fun Body(modifier: Modifier){
    var email by remember{
     mutableStateOf("")   
    }

    var password by remember {
        mutableStateOf("")
    }
    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        Email(email){email=it}
        Spacer(modifier = Modifier.height(8.dp))
        Password(password){password=it}
        Spacer(modifier = Modifier.height(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.height(25.dp))
        LoginButton(true)

        LoginDiver()

        SocialLogin()

        Footer(Modifier.align(Alignment.CenterHorizontally))
    }
    
}

@Composable
fun SocialLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.fb), contentDescription = "Facebook Logo"
        , modifier = Modifier.size(16.dp))
    Text(text = "Login with Facebook",
    fontSize = 14.sp,
    fontWeight = FontWeight.Bold,
    modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun LoginDiver() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color.LightGray)
                .height(1.dp)
                .weight(1f)
        )
        Text(text = "OR",
        modifier = Modifier
            .padding(16.dp),
        color = Color.LightGray
        )

        Divider(
            Modifier
                .background(Color.LightGray)
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Divider(modifier = modifier
            .background(Color.Blue)
            .height(1.dp)
            .fillMaxWidth())
        Spacer(modifier = modifier.height(24.dp))
    SingUp(modifier = modifier)
    }
}

@Composable
fun SingUp(modifier: Modifier) {

    Row(modifier = Modifier) {
        Text(text = "Don't have account?", fontSize = 12.sp, color = Color.Gray)
        Text(text = "Sing up", fontSize = 12.sp,
            modifier = modifier.padding(horizontal = 8.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Blue)
    }

}


@Composable
fun LoginButton(loginEnabled:Boolean) {
    Button(onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        enabled = loginEnabled) {

        Text(text = "Login")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier){
    Text(text = "Forgot Password",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        modifier = modifier.clickable {  })
}

@Composable
fun Password(password: String, onTextChange:(String)->Unit){
    TextField(value = password, onValueChange = {onTextChange(it)}, modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val image = if (){
                Icon(painter = painterResource(id = R.drawable.ic_visibility_off), contentDescription = "Hide password" )
            }else{
                Icon(painter = painterResource(id = R.drawable.ic_remove_red_eye), contentDescription = "Hide password" )
            }
        },

        )
}

@Composable
fun Email(email: String, onTextChange:(String)->Unit){
    TextField(value = email, onValueChange = {onTextChange(it)},

        modifier = Modifier.fillMaxWidth(),
    maxLines = 1,
    singleLine = true,
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun ImageLogo(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.insta),
        contentDescription = "INSTAGRAM LOGO", modifier = modifier)
}

@Composable
fun Header(modifier: Modifier){
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = "Close the app",
        modifier = modifier.clickable { activity.finish() })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ClonInstagramTheme {

    }
}