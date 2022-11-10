package com.freecodecloud.composetutorial.presentation.screen.auth.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.freecodecloud.composetutorial.presentation.screen.auth.PasswordRequirements
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme

@Composable
fun PasswordRequirements(
    modifier: Modifier = Modifier,
    satisfiedRequirements: List<PasswordRequirements>
) {

    Column(modifier = modifier) {

        PasswordRequirements.values().forEach { requirement ->
            Requirement(
                message = stringResource(id = requirement.label),
                satisfied = satisfiedRequirements.contains(requirement)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PasswordRequirementsPreview() {

    ComposeTutorialTheme {
        PasswordRequirements(satisfiedRequirements = listOf())
    }
}