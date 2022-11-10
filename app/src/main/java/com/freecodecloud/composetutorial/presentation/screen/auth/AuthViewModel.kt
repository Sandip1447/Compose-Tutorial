package com.freecodecloud.composetutorial.presentation.screen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel : ViewModel() {

    val uiState = MutableStateFlow(AuthState())

    fun handleEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.ToggleAuthMode -> {
                toggleAuthMode()
            }

            is AuthEvent.EmailChanged -> {
                updateEmail(event.emailAddress)
            }

            is AuthEvent.PasswordChanged -> {
                updatePassword(event.password)
            }

            is AuthEvent.Authenticate -> {
                // trigger network request
                authenticate()
            }
            is AuthEvent.ErrorDismissed -> {
                dismissError()
            }
        }
    }

    private fun toggleAuthMode() {
        val authMode = uiState.value.authMode
        val newAuthMode = if (
            authMode == AuthMode.SIGN_IN
        ) AuthMode.SIGN_IN
        else {
            AuthMode.SIGN_UP
        }
        uiState.value = uiState.value.copy(
            authMode = newAuthMode
        )
    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(
            email = email
        )
    }

    private fun updatePassword(password: String) {

        val requirements = mutableListOf<PasswordRequirements>()

        if (password.length > 7) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }

        if (password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        }

        if (password.any { it.isDigit() }) {
            requirements.add(PasswordRequirements.NUMBER)
        }

        uiState.value = uiState.value.copy(
            password = password
        )
    }

    private fun authenticate() {
        uiState.value = uiState.value.copy(
            isLoading = true
        )
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)
            withContext(Dispatchers.Main) {
                uiState.value = uiState.value.copy(
                    isLoading = false,
                    error = "Oh yes, You may request for network."
                )
            }
        }
    }

    private fun dismissError(){
        uiState.value = uiState.value.copy(
            error = null
        )
    }
}