package com.freecodecloud.composetutorial.presentation.screen.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.freecodecloud.composetutorial.presentation.screen.auth.AuthViewModel
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme


@Composable
fun Authentication() {

    val viewModel: AuthViewModel = viewModel()

    AuthenticationContent(
        modifier = Modifier.fillMaxWidth(),
        authState = viewModel.uiState.collectAsState().value,
        handleEvent = viewModel::handleEvent
    )

}

@Preview(showBackground = true)
@Composable
fun AuthenticationPreview() {
    ComposeTutorialTheme {
        Authentication()
    }
}

