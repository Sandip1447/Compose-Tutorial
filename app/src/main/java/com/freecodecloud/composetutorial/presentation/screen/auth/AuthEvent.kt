package com.freecodecloud.composetutorial.presentation.screen.auth

sealed class AuthEvent {

    object ToggleAuthMode : AuthEvent()

    class EmailChanged(val emailAddress: String) : AuthEvent()

    class PasswordChanged(val password: String) : AuthEvent()

    object Authenticate: AuthEvent()

    object ErrorDismissed: AuthEvent()
}
