package com.example.firstapp.ThoughtBubble

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstapp.MainScreen.newThoughtList
import com.example.firstapp.MainScreen.oldThoughtList
import com.example.firstapp.MainScreen.thoughtTitle
import com.example.firstapp.composenavigation.Screen
import com.example.firstapp.ui.theme.gradient


@Composable
fun EditThoughtScreen(navController: NavController, title: String?, oldThought: String?, newThought: String?) {
    var updatedTitleText by remember {
        mutableStateOf(title)
    }

    var updatedOldThoughtText by remember {
        mutableStateOf(oldThought)
    }

    var updatedNewThoughtText by remember {
        mutableStateOf(newThought)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {


        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center

        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
            ) {


                updatedTitleText?.let {
                    TextField(
                        value = it,
                        onValueChange = { that ->
                            updatedTitleText = that

                        },
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .padding(5.dp)
                    )
                }






                updatedOldThoughtText?.let {
                    TextField(
                        value = it,
                        onValueChange = { that ->
                            updatedOldThoughtText = that

                        },
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .padding(5.dp)

                    )
                }

                updatedNewThoughtText?.let {
                    TextField(
                        value = it,
                        onValueChange = { that ->
                            updatedNewThoughtText = that

                        },
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .padding(5.dp)


                    )
                }


            }

            Button(
                onClick = {
                    navController.navigate(Screen.MainScreen.route + "/{title}/{oldThought}/{newThought}")
                },
                modifier = Modifier
                    .height(60.dp)
                    .width(120.dp)
                    .padding(5.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text(text = "Cancel")
            }

            Button(
                onClick = {
                    thoughtTitle[thoughtTitle.indexOf(title)] = updatedTitleText
                    oldThoughtList[oldThoughtList.indexOf(oldThought)] = updatedOldThoughtText
                    newThoughtList[newThoughtList.indexOf(newThought)] = updatedNewThoughtText
                    navController.navigate(Screen.MainScreen.route + "/{title}/{oldThought}/{newThought}")

                },
                modifier = Modifier
                    .height(60.dp)
                    .width(100.dp)
                    .padding(5.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Text(text = "Save")

            }

        }

    }



}