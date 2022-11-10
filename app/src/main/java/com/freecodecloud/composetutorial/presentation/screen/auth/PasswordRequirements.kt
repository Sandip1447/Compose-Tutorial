package com.freecodecloud.composetutorial.presentation.screen.auth

import androidx.annotation.StringRes
import com.freecodecloud.composetutorial.R

enum class PasswordRequirements(
    @StringRes val label: Int
) {
    CAPITAL_LETTER(R.string.password_requirement_capital),
    NUMBER(R.string.password_requirement_digit),
    EIGHT_CHARACTERS(R.string.password_requirement_characters)
}