package com.freecodecloud.composetutorial.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.freecodecloud.composetutorial.presentation.MainViewModel
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme

@Composable
fun CountDownView(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<MainViewModel>()

    val time = viewModel.countDownFlow.collectAsState(initial = 10)

    Box(modifier = modifier) {

        CountDownText(
            text = time.value.toString(),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Composable
fun CountDownText(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 30.sp
    )
}

@Preview(showBackground = true)
@Composable
fun CountDownTextPreview() {
    ComposeTutorialTheme {
        CountDownText(text = "Jetpack Compose Guideline")
    }
}
