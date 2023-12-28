package com.example.firstapp.ThoughtBubble

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstapp.MainScreen.newThoughtCardHeight
import com.example.firstapp.MainScreen.newThoughtCardWidth
import com.example.firstapp.MainScreen.newThoughtList
import com.example.firstapp.MainScreen.newThoughtTextOpacityList
import com.example.firstapp.MainScreen.newThoughtTextSizeList
import com.example.firstapp.MainScreen.oldThoughtCardHeight
import com.example.firstapp.MainScreen.oldThoughtCardWidth
import com.example.firstapp.MainScreen.oldThoughtList
import com.example.firstapp.MainScreen.oldThoughtTextOpacityList
import com.example.firstapp.MainScreen.oldThoughtTextSizeList
import com.example.firstapp.MainScreen.thoughtTitle
import com.example.firstapp.composenavigation.Screen



var int = 0
@Composable
fun ThoughtBubble(navController: NavController, title: String?, oldThought: String?, newThought: String?, currentIndex: Int) {


    val oldThoughtOpacity by remember {
        mutableFloatStateOf(oldThoughtTextOpacityList[currentIndex])
    }

    val newThoughtOpacity by remember {
        mutableFloatStateOf(newThoughtTextOpacityList[currentIndex])
    }

    val oldThoughtSize by remember {
        mutableStateOf(oldThoughtTextSizeList[currentIndex])
    }

    val newThoughtSize by remember {
        mutableStateOf(newThoughtTextSizeList[currentIndex])
    }

    var expanded by remember {
        mutableStateOf(false)
    }



    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth(0.8f)

            .padding(10.dp)
            .clickable {

                expanded = !expanded
            }
    ) {

        if (!expanded) {
            if (title != null) {
                Text(
                    text = title,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(10.dp)


                )
            }
        }

        else {

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f),
                horizontalArrangement = Arrangement.End

            ){

                Button(onClick = {
                    int = currentIndex
                    navController.navigate(Screen.PracticeThoughtScreen.withArgs(title, oldThought, newThought))
                }) {


                    //Text(text = "Practice")
                    Icon(imageVector = Icons.Filled.Build, contentDescription = "Practice")
                }

                Button(onClick = {
                    navController.navigate(Screen.EditThoughtScreen.withArgs(title, oldThought, newThought))
                }) {
                    //Text(text = "Edit")
                    Icon(imageVector = Icons.Filled.Create, contentDescription = "Edit")

                }

                Button(onClick = {
                    thoughtTitle.remove(title)
                    oldThoughtList.remove(oldThought)
                    newThoughtList.remove(newThought)
                    oldThoughtTextOpacityList.remove(oldThoughtTextOpacityList[currentIndex])
                    newThoughtTextOpacityList.remove(newThoughtTextOpacityList[currentIndex])
                    oldThoughtTextSizeList.remove(oldThoughtTextSizeList[currentIndex])
                    newThoughtTextSizeList.remove(newThoughtTextSizeList[currentIndex])

                    oldThoughtCardHeight.remove(oldThoughtCardHeight[currentIndex])
                    oldThoughtCardWidth.remove(oldThoughtCardWidth[currentIndex])
                    newThoughtCardHeight.remove(newThoughtCardHeight[currentIndex])
                    newThoughtCardWidth.remove(newThoughtCardWidth[currentIndex])

                }) {
                    //Text(text = "Delete")
                    Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
                }





            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ){


                if (title != null) {
                    Text(
                        text = title,
                        modifier = Modifier.padding(10.dp),
                        fontSize = 25.sp

                    )
                }



                if (oldThought != null) {
                    Text(
                        text = oldThought,
                        modifier = Modifier
                            .padding(10.dp)
                            .alpha(oldThoughtOpacity),
                        fontSize = oldThoughtSize

                    )
                }
                if (newThought != null) {
                    Text(
                        text = newThought,
                        modifier = Modifier
                            .padding(10.dp)
                            .alpha(newThoughtOpacity),
                        fontSize = newThoughtSize
                    )
                }
            }




        }





    }

}