package com.example.firstapp.composenavigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firstapp.MainScreen.MainScreen
import com.example.firstapp.ThoughtBubble.EditThoughtScreen
import com.example.firstapp.ThoughtBubble.PracticeThoughtScreen
import com.example.firstapp.titlescreen.TitleScreen
import com.example.firstapp.oldthoughtscreen.OldThoughtScreen
import com.example.firstapp.newthoughtscreen.NewThoughtScreen
import com.example.firstapp.reviewthoughtscreen.ReviewThoughtsScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route + "/{title}/{oldThought}/{newThought}"
    ) {



            composable(
                route = Screen.MainScreen.route + "/{title}/{oldThought}/{newThought}",
                        arguments = listOf(
                        navArgument("title") {
                            type = NavType.StringType
                        },
                navArgument("oldThought") {
                    type = NavType.StringType
                },

                navArgument("newThought") {
                    type = NavType.StringType
                }

            )

            ) {entry ->
                MainScreen(
                    navController = navController,
                    title = entry.arguments?.getString("title"),
                    oldThought = entry.arguments?.getString("oldThought"),
                    newThought = entry.arguments?.getString("newThought")
                )
            }



        composable(
            route = Screen.TitleScreen.route
        ) {
            TitleScreen(navController = navController)
        }
        
        composable(
            route = Screen.OldThoughtScreen.route + "/{title}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                }
            )
        ) { entry ->

                OldThoughtScreen(
                    navController = navController,
                    title = entry.arguments?.getString("title")
                )
        }
        composable(
            route = Screen.NewThoughtScreen.route + "/{title}/{oldThought}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                },
                navArgument("oldThought") {
                    type = NavType.StringType
                }

            )
        ) {oldThoughtEntry ->

                NewThoughtScreen(
                    navController = navController,
                    title = oldThoughtEntry.arguments?.getString("title"),
                    oldThought = oldThoughtEntry.arguments?.getString("oldThought")
                )
        }

        composable(
            route = Screen.ReviewThoughtScreen.route + "/{title}/{oldThought}/{newThought}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                },
                navArgument("oldThought") {
                    type = NavType.StringType
                },

                navArgument("newThought") {
                    type = NavType.StringType
                }

            )
        ) {
                ReviewThoughtsScreen(
                    navController = navController,
                    title = it.arguments?.getString("title"),
                    oldThought = it.arguments?.getString("oldThought"),
                    newThought = it.arguments?.getString("newThought")
                )
        }

        composable(
            route = Screen.EditThoughtScreen.route + "/{title}/{oldThought}/{newThought}",
            arguments = listOf(
                navArgument("title") {
                        type = NavType.StringType
                    },
            navArgument("oldThought") {
                type = NavType.StringType
            },

            navArgument("newThought") {
                type = NavType.StringType
            }

        )


        ) {

            EditThoughtScreen(
                navController = navController,
                title = it.arguments?.getString("title"),
                oldThought = it.arguments?.getString("oldThought"),
                newThought = it.arguments?.getString("newThought")
            )


        }




        composable(
            route = Screen.PracticeThoughtScreen.route + "/{title}/{oldThought}/{newThought}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                },
                navArgument("oldThought") {
                    type = NavType.StringType
                },

                navArgument("newThought") {
                    type = NavType.StringType
                }

            )


        ) {

            PracticeThoughtScreen(
                navController = navController,
                title = it.arguments?.getString("title"),
                oldThought = it.arguments?.getString("oldThought"),
                newThought = it.arguments?.getString("newThought")
            )


        }



    }
}




























