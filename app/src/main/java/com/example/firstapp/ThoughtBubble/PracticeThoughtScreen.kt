package com.example.firstapp.ThoughtBubble

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstapp.MainScreen.newThoughtCardHeight
import com.example.firstapp.MainScreen.newThoughtCardWidth
import com.example.firstapp.MainScreen.newThoughtTextOpacityList
import com.example.firstapp.MainScreen.newThoughtTextSizeList
import com.example.firstapp.MainScreen.oldThoughtCardHeight
import com.example.firstapp.MainScreen.oldThoughtCardWidth
import com.example.firstapp.MainScreen.oldThoughtTextOpacityList
import com.example.firstapp.MainScreen.oldThoughtTextSizeList
import com.example.firstapp.composenavigation.Screen
import com.example.firstapp.ui.theme.gradient


@Composable
fun PracticeThoughtScreen(navController: NavController, title: String?, oldThought: String?, newThought: String?) {
    var oldThoughtOpacity by remember {
        mutableFloatStateOf(oldThoughtTextOpacityList[int])
    }

    var newThoughtOpacity by remember {
        mutableFloatStateOf(newThoughtTextOpacityList[int])
    }

    var oldThoughtSize by remember {
        mutableStateOf(oldThoughtTextSizeList[int])
    }

    var newThoughtSize by remember {
        mutableStateOf(newThoughtTextSizeList[int])
    }

    var oldThoughtHeight by remember {
        mutableIntStateOf(oldThoughtCardHeight[int])
    }

    var oldThoughtWidth by remember {
        mutableIntStateOf(oldThoughtCardWidth[int])
    }

    var newThoughtHeight by remember {
        mutableIntStateOf(newThoughtCardHeight[int])
    }

    var newThoughtWidth by remember {
        mutableIntStateOf(newThoughtCardWidth[int])
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()



        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                if (title != null) {

                    Text(
                        text = title,
                        modifier = Modifier
                            .padding(10.dp),
                        fontSize = 25.sp
                    )

                }

                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    border = BorderStroke(1.dp, Color.Black),
                    modifier = Modifier
                        .width(oldThoughtWidth.dp)
                        .height(oldThoughtHeight.dp)
                        .padding(10.dp)

                ) {


                    if (oldThought != null) {
                        Text(
                            text = oldThought,
                            modifier = Modifier
                                .padding(5.dp)
                                .alpha(oldThoughtOpacity),
                            fontSize = oldThoughtSize


                        )
                    }


                }

                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    border = BorderStroke(1.dp, Color.Black),
                    modifier = Modifier
                        .width(newThoughtWidth.dp)
                        .height(newThoughtHeight.dp)
                        .padding(10.dp)

                ) {


                    if (newThought != null) {
                        Text(
                            text = newThought,
                            modifier = Modifier
                                .padding(5.dp)
                                .alpha(newThoughtOpacity),
                            fontSize = newThoughtSize
                        )
                    }


                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    horizontalArrangement = Arrangement.Center

                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .fillMaxHeight(0.2f)
                    ) {
                        Text(
                            text = "Repeat the new thought 5 times then click the button",
                            fontSize = 15.sp
                        )
                    }

                    Button(
                        onClick = {
                            oldThoughtOpacity -= 0.05f
                            newThoughtOpacity += 0.05f
                            oldThoughtSize = oldThoughtSize.times(0.9f)
                            newThoughtSize = newThoughtSize.times(1.05f)
                            oldThoughtHeight -= 5
                            oldThoughtWidth -= 5
                            newThoughtHeight += 5
                            newThoughtWidth += 5

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Practice Button"
                        )


                    }


                }


            }


            Button(
                onClick = {
                    navController.navigate(Screen.MainScreen.route + "/{title}/{oldThought}/{newThought}")
                },
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(5.dp)
                ,
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Back")
            }

            Button(
                onClick = {
                    oldThoughtTextOpacityList[int] = oldThoughtOpacity
                    oldThoughtTextSizeList[int] = oldThoughtSize
                    newThoughtTextOpacityList[int] = newThoughtOpacity
                    newThoughtTextSizeList[int] = newThoughtSize
                    oldThoughtCardHeight[int] = oldThoughtHeight
                    oldThoughtCardWidth[int] = oldThoughtWidth
                    newThoughtCardWidth[int] = newThoughtWidth
                    newThoughtCardHeight[int] = newThoughtHeight

                    navController.navigate(Screen.MainScreen.route + "/{title}/{oldThought}/{newThought}")
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(5.dp)
                ,
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Save")

            }


        }


    }



}