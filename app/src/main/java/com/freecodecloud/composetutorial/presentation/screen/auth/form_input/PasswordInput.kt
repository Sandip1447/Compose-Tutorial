package com.freecodecloud.composetutorial.presentation.screen.auth.form_input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.freecodecloud.composetutorial.R
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String?,
    onPasswordChanged: (password: String) -> Unit,
    onDoneClicked: () -> Unit
) {

    var isPasswordHidden by remember { mutableStateOf(true) }

    TextField(
        modifier = modifier,
        value = password ?: "",
        onValueChange = { newValue ->
            onPasswordChanged(newValue)
        },
        label = {
            Text(text = stringResource(id = R.string.label_password))
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onDoneClicked()
            }
        ),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = null)
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable(
                    onClickLabel = stringResource(
                        id = if (isPasswordHidden) {
                            R.string.show_password
                        } else {
                            R.string.hide_password
                        }
                    )
                ) {
                    isPasswordHidden = !isPasswordHidden
                },
                imageVector = if (isPasswordHidden) {
                    Icons.Default.Visibility
                } else {
                    Icons.Default.VisibilityOff
                }, contentDescription = null
            )
        }
    )

}

@Preview(showBackground = true)
@Composable
fun PasswordInputPreview() {

    ComposeTutorialTheme {
        PasswordInput(password = "", onPasswordChanged = {}, onDoneClicked = {})
    }
}