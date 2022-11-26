package com.example.cloninstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.cloninstagram.login.domain.LoginUseCase
import com.example.cloninstagram.login.ui.LoginScreen
import com.example.cloninstagram.login.ui.LoginViewModel
import com.example.cloninstagram.ui.theme.ClonInstagramTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel:LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ClonInstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen(loginViewModel)
                    //SimpleRecycleView()
                    //SuperHerosView()
                    //SuperHerosGridView()
                //ScafoldExample()
                /*val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.Screen_1.routes){
                        composable("home"){ ScafoldExample()}
                        composable(Routes.Screen_1.routes){ Screen_First(navigationController) }
                        composable(Routes.Screen_2.routes){ Screen_Second(navigationController) }
                        composable(Routes.Screen_3.routes){ Screen_Third(navigationController) }
                        composable("Screen_4/{name}", arguments = listOf(navArgument("name"){
                            type = NavType.IntType
                        })){
                            navBackStackEntry ->
                            Screen_Quarter(navigationController = navigationController,
                                name = navBackStackEntry.arguments?.getInt("name")?:0)
                        }
                    }*/
                }
            }
        }
    }
}



