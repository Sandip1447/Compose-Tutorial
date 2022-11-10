package com.freecodecloud.composetutorial.presentation.screen.auth.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.freecodecloud.composetutorial.R
import com.freecodecloud.composetutorial.presentation.screen.auth.AuthMode
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme

@Composable
fun AuthenticationButton(
    modifier: Modifier = Modifier,
    authMode: AuthMode,
    enableAuthentication: Boolean,
    onClicked: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { onClicked() },
        enabled = enableAuthentication
    ) {
        Text(
            text = stringResource(
                id = if (authMode == AuthMode.SIGN_IN) {
                    R.string.sign_in
                } else {
                    R.string.create_account
                }
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AuthenticationButtonPreview() {

    ComposeTutorialTheme {
        AuthenticationButton(
            authMode = AuthMode.SIGN_UP,
            enableAuthentication = false,
            onClicked = {})
    }
}