package com.freecodecloud.composetutorial.presentation.screen.auth.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freecodecloud.composetutorial.R
import com.freecodecloud.composetutorial.presentation.screen.auth.AuthMode
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme

@Composable
fun ToggleAuthenticationMode(
    modifier: Modifier = Modifier,
    authMode: AuthMode,
    toggleAuthentication: () -> Unit
) {

    Surface(modifier = modifier.padding(top = 16.dp), elevation = 8.dp) {
        TextButton(onClick = { toggleAuthentication() }) {
            Text(
                text = stringResource(
                    id = if (authMode == AuthMode.SIGN_IN) {
                        R.string.action_need_account
                    } else {
                        R.string.action_already_have_account
                    }
                )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ToggleAuthenticationModePreview() {
    ComposeTutorialTheme {
        ToggleAuthenticationMode(authMode = AuthMode.SIGN_IN, toggleAuthentication = {})
    }
}