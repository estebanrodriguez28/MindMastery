package com.example.firstapp.reviewthoughtscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstapp.MainScreen.newThoughtList
import com.example.firstapp.MainScreen.oldThoughtList
import com.example.firstapp.MainScreen.thoughtTitle
import com.example.firstapp.composenavigation.Screen
import com.example.firstapp.oldthoughtscreen.currentNewThought
import com.example.firstapp.oldthoughtscreen.currentOldThought
import com.example.firstapp.oldthoughtscreen.currentTitle
import com.example.firstapp.ui.theme.gradient


@Composable
fun ReviewThoughtsScreen(navController: NavController, title: String?, oldThought: String?, newThought: String?) {



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {


        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp, end = 10.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Text(text = "Review Thought Created", modifier = Modifier.padding(15.dp))
                    Text(text = "Title: ", modifier = Modifier.padding(10.dp))
                    Box(
                        modifier = Modifier
                            .border(
                                1.dp,
                                Color.Black,
                                shape = MaterialTheme.shapes.small
                            )

                            .background(Color.White)
                    ) {
                        Text(text = "$title", modifier = Modifier.padding(10.dp))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Your Old Thought: ", modifier = Modifier.padding(10.dp))
                    Box(
                        modifier = Modifier
                            .border(
                                1.dp,
                                Color.Black,
                                shape = MaterialTheme.shapes.small
                            )
                            .background(Color.White)
                    ) {
                        Text(text = "$oldThought", modifier = Modifier.padding(10.dp))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Your New Thought: ", modifier = Modifier.padding(10.dp))
                    Box(
                        modifier = Modifier
                            .border(
                                1.dp,
                                Color.Black,
                                shape = MaterialTheme.shapes.small
                            )
                            .background(Color.White)
                    ) {
                        Text(text = "$newThought", modifier = Modifier.padding(10.dp))
                    }


                }

            }



            Button(
                onClick = {

                    if (title != null) {
                        currentTitle.value = title
                    }

                    if (oldThought != null) {
                        currentOldThought.value = oldThought
                    }

                    if (newThought != null) {
                        currentNewThought.value = newThought
                    }

                    navController.navigate(Screen.NewThoughtScreen.withArgs(title, oldThought))
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

                    currentTitle.value = ""
                    currentOldThought.value = ""
                    currentNewThought.value = ""

                    thoughtTitle += title
                    oldThoughtList += oldThought
                    newThoughtList += newThought

                    navController.navigate(
                        Screen.MainScreen.withArgs(
                            title,
                            oldThought,
                            newThought
                        )
                    )
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(5.dp)
                ,
                shape = RoundedCornerShape(20.dp)

            ) {
                Text(text = "Finish")

            }


        }

    }


}