package com.example.firstapp.titlescreen

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
import com.example.firstapp.oldthoughtscreen.currentTitle
import com.example.firstapp.ui.theme.gradient

@Composable
fun TitleScreen(navController: NavController) {
    var text by remember {
        mutableStateOf(currentTitle.value)
    }

    var errorMessage by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    )
    {

        Box(
            modifier = Modifier
                .fillMaxSize()


        ) {


            TextField(
                value = text,
                onValueChange = {
                    text = it

                },

                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .fillMaxHeight(0.15f)
                    .align(Alignment.Center),
                placeholder = { Text(text = "Enter a title") },


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

                    if (text.isNotBlank()) {
                        // Navigate to the next screen
                        navController.navigate(Screen.OldThoughtScreen.withArgs(text))
                    } else {
                        // Set an error message
                        errorMessage = "Please enter a title."
                    }

                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(5.dp)
                ,
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Next")

            }

        }
    }

}