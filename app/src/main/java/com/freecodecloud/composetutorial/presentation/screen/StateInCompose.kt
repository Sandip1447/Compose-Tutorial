package com.freecodecloud.composetutorial.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme

//https://developer.android.com/codelabs/jetpack-compose-state#0

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableStateOf(0) }

    StatelessCounter(modifier = modifier, counter = counter, onIncrement = { counter++ })

}

@Composable
private fun StatelessCounter(
    modifier: Modifier,
    counter: Int,
    onIncrement: () -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {

        if (counter > 0) {
            Text(text = "You've had $counter glasses.")
        }
        Button(
            onClick = onIncrement,
            enabled = counter < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Add one")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    ComposeTutorialTheme {
        StatefulCounter()
    }
}


@Composable
fun EmailField(modifier: Modifier = Modifier) {
    TextField(value = "", onValueChange = {})
}

@Preview(showBackground = true)
@Composable
fun EmailFieldPreview() {

}