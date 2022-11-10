package com.freecodecloud.composetutorial.presentation.screen.auth.form

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freecodecloud.composetutorial.presentation.screen.auth.AuthMode
import com.freecodecloud.composetutorial.presentation.screen.auth.PasswordRequirements
import com.freecodecloud.composetutorial.presentation.screen.auth.components.AuthenticationButton
import com.freecodecloud.composetutorial.presentation.screen.auth.components.PasswordRequirements
import com.freecodecloud.composetutorial.presentation.screen.auth.components.ToggleAuthenticationMode
import com.freecodecloud.composetutorial.presentation.screen.auth.form_input.EmailInput
import com.freecodecloud.composetutorial.presentation.screen.auth.form_input.PasswordInput
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme


@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authMode: AuthMode,
    email: String?,
    password: String?,
    completePasswordRequirements: List<PasswordRequirements>,
    enableAuthentication: Boolean,
    onEmailChanged: (email: String) -> Unit,
    onPasswordChanged: (password: String) -> Unit,
    onAuthenticate: () -> Unit,
    onToggleMode: () -> Unit
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(32.dp))
        AuthTitle(authMode = authMode)
        Spacer(modifier = Modifier.height(40.dp))

        val passwordFocusRequester = FocusRequester()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            elevation = 4.dp
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                EmailInput(
                    email = email ?: "",
                    onEmailChanged = onEmailChanged
                ) {
                    passwordFocusRequester.requestFocus()
                }

                Spacer(modifier = Modifier.height(16.dp))
                PasswordInput(
                    modifier = modifier.focusRequester(passwordFocusRequester),
                    password = password ?: "",
                    onPasswordChanged = onPasswordChanged,
                    onDoneClicked = onAuthenticate
                )
                Spacer(modifier = Modifier.height(12.dp))
                AnimatedVisibility(visible = authMode == AuthMode.SIGN_UP) {
                    PasswordRequirements(
                        satisfiedRequirements = completePasswordRequirements
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

                AuthenticationButton(
                    authMode = authMode,
                    enableAuthentication = enableAuthentication,
                    onClicked = onAuthenticate
                )

            }

        }

        Spacer(modifier = Modifier.weight(1f))
        ToggleAuthenticationMode(
            authMode = authMode,
            modifier = Modifier.fillMaxWidth(),
            toggleAuthentication = {
                onToggleMode()
            })
    }
}


@Preview(showBackground = true)
@Composable
fun AuthenticationFormPreview() {
    ComposeTutorialTheme {
        AuthenticationForm(
            authMode = AuthMode.SIGN_IN,
            email = "",
            password = "",
            completePasswordRequirements = listOf(),
            enableAuthentication = false,
            onEmailChanged = {},
            onPasswordChanged = {},
            onAuthenticate = {},
            onToggleMode = {}
        )
    }
}
