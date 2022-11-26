/*
package com.example.cloninstagram

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cloninstagram.model.SuperHeros
import kotlinx.coroutines.launch

@Composable
fun SimpleRecycleView(){
    val Mylist = listOf("Spiderman", "Thor", "Ironman", "Capitan America")
    LazyColumn(){
        item { Text(text = "Header") }
        items(Mylist){
            Text(text = "$it")
        }
        item { Text(text = "Footer") }
    }
}

@Composable
fun ItemHero(superHeros: SuperHeros, onItemSelected: (SuperHeros) -> Unit){
    Card(border = BorderStroke(2.dp, color = Color.LightGray), modifier = Modifier
        .width(200.dp)
        .clickable { onItemSelected(superHeros) }){
        Column() {
            Image(painter = painterResource(id = superHeros.photo),
                contentDescription = "Image of ${superHeros.superHeroName}",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
                )
            Text(text = superHeros.superHeroName, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = superHeros.realName, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp)
            Text(text = superHeros.publiser, fontSize = 10.sp, modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp))
        }
    }
}

@Composable
fun SuperHerosView(){
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeros()) {SuperHeros ->
            ItemHero(superHeros = SuperHeros){
                Toast.makeText(
                    context,
                    it.superHeroName,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHerosGridView(){
    val context = LocalContext.current
    LazyVerticalGrid(cells = GridCells.Adaptive(300.dp), content = {
        items(getSuperHeros()) {SuperHeros ->
            ItemHero(superHeros = SuperHeros){
                Toast.makeText(
                    context,
                    it.superHeroName,
                    Toast.LENGTH_SHORT).show()
            }
        }
    })


}

@Composable
fun SuperHerosWithSpecialControlView(){
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val corrutinScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ){
            items(getSuperHeros()){ superHeros ->
                ItemHero(superHeros = superHeros){
                    Toast.makeText(context,
                    it.superHeroName,
                    Toast.LENGTH_SHORT).show()
                }


            }



        }

       /*val showButton by remember{
            derivedStateOf {
                rvState.firstVisibleItemIndex>0
            }
        }

        rvState.firstVisibleItemScrollOffset

        if (showButton)
            Button(onClick = {
                corrutinScope.launch {
                    rvState.animateScrollToItem(0)
                }

            },
                modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Click me")
            }*/
    }
}




fun getSuperHeros():List<SuperHeros>{
    return listOf(
        SuperHeros("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHeros("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        SuperHeros("Iron man", "Tony Stark", "Marvel", R.drawable.ironman),
        SuperHeros("Capitan america", "Steve Rogers", "Marvel", R.drawable.capitanamerica)


    )
}*/
