package com.example.cloninstagram

import android.widget.ShareActionProvider
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ScafoldExample(){
    val scaffoldState = rememberScaffoldState()
    val corruntineScope = rememberCoroutineScope()

    Scaffold(  topBar = {
        MyTopAppBars( onItemSelected = {
            corruntineScope.launch {
                scaffoldState.snackbarHostState
                    .showSnackbar("YOU HAVE BEEN CLICK $it")
            }
        },
            onCloseDrawer = {
                corruntineScope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        )//FIN MI TOP BAR
    }//FIN TOP BAR
    , scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigationMenu()},
        floatingActionButton = { MyFAB()},
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        /*drawerContent = { MyDrawer(
            corruntineScope.launch {
                scaffoldState.drawerState.close()
            }
        )},*/
        drawerGesturesEnabled = false
    ){

    }
}
    @Composable
    fun MyFAB(){
        FloatingActionButton(onClick = { /*TODO*/ },
        backgroundColor = Color.LightGray,
        contentColor = Color.Red,
        ) {

            Icon(imageVector = Icons.Default.Add
                ,contentDescription = "ADD" )

        }
    }

    @Composable
    fun MyBottomNavigationMenu(){

        var selected by remember{
            mutableStateOf(0)
        }

   BottomNavigation() {
       BottomNavigationItem(selected = selected == 0, onClick = { selected = 0 },
       icon ={ Icon(imageVector = Icons.Default.Home, contentDescription = "Home" )},
       label ={ Text(text = "Home")})

       BottomNavigationItem(selected = selected == 1, onClick = { selected = 1 },
           icon ={ Icon(imageVector = Icons.Default.Favorite, contentDescription = "Fav" )},
           label ={ Text(text = "fav")})

       BottomNavigationItem(selected = selected == 2, onClick = { selected = 2 },
           icon ={ Icon(imageVector = Icons.Default.Person, contentDescription = "Person" )},
           label ={ Text(text = "Person")})

       }
   }



@Composable
fun MyDrawer(onCloseDrawer: () -> Unit){
    val mylist = listOf("Menu One", "Menu Two", "Menu Three")
    Column(Modifier.padding(8.dp)) {
        mylist.forEach(){
            Text(text = it,
                Modifier
                    .clickable { onCloseDrawer }
                    .fillMaxWidth()
                    .padding(8.dp))

        }
    }
}

@Composable
fun MyTopAppBars(onItemSelected: (String) -> Unit, onCloseDrawer:()-> Unit){

    TopAppBar(
        title = { Text(text = "Menu Top App Bar")},
        backgroundColor = Color.Red,
        contentColor = Color(0x6cf3d5),
        navigationIcon = {
            IconButton(onClick = { onItemSelected("Back") }) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = "Menu")
            }
        },

        actions = {

            IconButton(onClick = { onItemSelected("Search") }) {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = "Search")
            }

            IconButton(onClick = { onItemSelected("Close") }) {
                Icon(imageVector = Icons.Default.Close,
                    contentDescription = "Close")
            }

        }

    )

}

