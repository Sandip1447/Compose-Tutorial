package com.freecodecloud.composetutorial.presentation.screen.auth.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.freecodecloud.composetutorial.presentation.screen.auth.AuthEvent
import com.freecodecloud.composetutorial.presentation.screen.auth.AuthState
import com.freecodecloud.composetutorial.presentation.screen.auth.form.AuthenticationForm
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme

@Composable
fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authState: AuthState,
    handleEvent: (event: AuthEvent) -> Unit
) {

    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {

        if (authState.isLoading) {
            CircularProgressIndicator()
        } else {
            AuthenticationForm(
                authMode = authState.authMode,
                email = authState.email,
                password = authState.password,
                onEmailChanged = {
                    handleEvent(AuthEvent.EmailChanged(it))
                },
                onPasswordChanged = {
                    handleEvent(AuthEvent.PasswordChanged(it))
                },
                completePasswordRequirements = listOf(),
                enableAuthentication = authState.isFormValid(),
                onAuthenticate = {
                    handleEvent(AuthEvent.Authenticate)
                },
                onToggleMode = {
                    handleEvent(AuthEvent.ToggleAuthMode)
                })
            authState.error?.let { error ->
                AuthenticationErrorDialog(error = error, dismissError = {
                    handleEvent(AuthEvent.ErrorDismissed)
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthenticationContentPreview() {
    ComposeTutorialTheme {
        AuthenticationContent(authState = AuthState(), handleEvent = {})
    }
}