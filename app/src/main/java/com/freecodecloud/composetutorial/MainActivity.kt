package com.freecodecloud.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {

    // private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
            }
        }
    }
}
