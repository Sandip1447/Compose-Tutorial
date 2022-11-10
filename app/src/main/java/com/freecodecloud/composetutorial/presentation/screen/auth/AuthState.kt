package com.freecodecloud.composetutorial.presentation.screen.auth

data class AuthState(
    val authMode: AuthMode = AuthMode.SIGN_IN,
    val email: String? = null,
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    /* show a progress indicator to the user so that they know a request is taking place */
    val isLoading: Boolean = false,
    val error: String? = null
) {
    fun isFormValid(): Boolean {
        return password?.isNotEmpty() == true &&
                email?.isNotEmpty() == true &&
                (authMode == AuthMode.SIGN_IN || passwordRequirements.containsAll(
                    PasswordRequirements.values().toList()
                ))
    }
}
