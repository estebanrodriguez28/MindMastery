package com.example.firstapp.newthoughtscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstapp.composenavigation.Screen
import com.example.firstapp.oldthoughtscreen.currentNewThought
import com.example.firstapp.ui.theme.gradient


@Composable
fun NewThoughtScreen(navController: NavController, title: String?, oldThought: String?){
    var errorMessage by remember { mutableStateOf("") }


    var text by remember {
        mutableStateOf(currentNewThought.value)
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

            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.25f)
                    .align(Alignment.Center),
                placeholder = { Text(text = "Change the old thought into a new thought that will serve you in achieving your goals") }

            )

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Button(
                onClick = {
                    navController.navigate(Screen.OldThoughtScreen.withArgs(title))
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
                    if (text.isNotBlank()) {
                        // Navigate to the next screen
                        navController.navigate(
                            Screen.ReviewThoughtScreen.withArgs(
                                title,
                                oldThought,
                                text
                            )
                        )
                    } else {
                        // Set an error message
                        errorMessage = "Please enter your new thought."
                    }


                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(5.dp)
                ,
                shape = RoundedCornerShape(20.dp)

            ) {
                Text(text = "Enter")

            }
        }


    }

}