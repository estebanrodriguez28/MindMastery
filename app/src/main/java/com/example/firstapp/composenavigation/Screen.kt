package com.example.firstapp.composenavigation

sealed class Screen (val route: String) {
        object MainScreen : Screen("main_screen")
        object TitleScreen : Screen("title_screen")
        object OldThoughtScreen : Screen("old_thought_screen")
        object NewThoughtScreen : Screen("new_thought_screen")
        object ReviewThoughtScreen : Screen("review_thought_screen")
        object EditThoughtScreen : Screen("edit_thought_screen")
        object PracticeThoughtScreen : Screen("practice_thought_screen")

        fun withArgs(vararg args: String?): String {
                return buildString {
                        append(route)
                        args.forEach {arg->
                                append("/$arg")
                        }
                }
        }

}
