package com.freecodecloud.composetutorial.presentation.screen.auth.form

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.freecodecloud.composetutorial.R
import com.freecodecloud.composetutorial.presentation.screen.auth.AuthMode
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme


/*Our title will now be displaying a string based on the AuthenticationMode that is provided to the function.*/
@Composable
fun AuthTitle(
    modifier: Modifier = Modifier,
    authMode: AuthMode
) {
    Text(
        text = stringResource(
            id = if (authMode == AuthMode.SIGN_IN) {
                R.string.dummy_title
            } else {
                R.string.dummy_content
            }
        ),
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
    )
}

@Preview(showBackground = true)
@Composable
fun AuthTitlePreview() {
    ComposeTutorialTheme {
        AuthTitle(authMode = AuthMode.SIGN_IN)
    }
}