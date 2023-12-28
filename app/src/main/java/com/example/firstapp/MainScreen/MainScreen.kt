package com.example.firstapp.MainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstapp.composenavigation.Screen
import com.example.firstapp.ThoughtBubble.ThoughtBubble
import com.example.firstapp.ui.theme.gradient

var thoughtTitle = mutableStateListOf<String?>()
var oldThoughtList = mutableStateListOf<String?>()
var newThoughtList = mutableStateListOf<String?>()



var oldThoughtTextOpacityList = mutableStateListOf<Float>()
var newThoughtTextOpacityList = mutableStateListOf<Float>()

var oldThoughtTextSizeList = mutableStateListOf<TextUnit>()
var newThoughtTextSizeList = mutableStateListOf<TextUnit>()


var oldThoughtCardHeight = mutableStateListOf<Int>()
var oldThoughtCardWidth = mutableStateListOf<Int>()

var newThoughtCardHeight = mutableStateListOf<Int>()
var newThoughtCardWidth = mutableStateListOf<Int>()
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, title: String?, oldThought: String?, newThought: String?) {





    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    )
    {





        if (title != null && oldThought != null && newThought != null) {


            Box(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                    //.verticalScroll(state = scrollState)
                    ,
                    //verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    itemsIndexed(thoughtTitle) { index, thoughtTitle ->
                        oldThoughtTextOpacityList.add(1.0f)
                        oldThoughtTextSizeList.add(30.sp)
                        newThoughtTextOpacityList.add(0.5f)
                        newThoughtTextSizeList.add(15.sp)
                        oldThoughtCardHeight.add(150)
                        oldThoughtCardWidth.add(300)
                        newThoughtCardHeight.add(150)
                        newThoughtCardWidth.add(300)



                        ThoughtBubble(
                            navController,
                            title = thoughtTitle,
                            oldThought = oldThoughtList[index],
                            newThought = newThoughtList[index],
                            currentIndex = index
                        )


                    }


                }
            }


        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom
            ){
                PlainTooltipBox(tooltip = {
                    Text(text = "Create a new thought")
                }) {

                    Button(
                        onClick = {
                            navController.navigate(Screen.TitleScreen.route)
                        },
                        modifier = Modifier
                            //.align(Alignment.BottomEnd)
                            .padding(5.dp)
                            .tooltipAnchor(),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Create a new thought"
                        )
                    }

                }
            }

        }

    }


}