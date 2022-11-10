package com.freecodecloud.composetutorial.presentation.screen.task_list

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.freecodecloud.composetutorial.presentation.screen.StatefulCounter
import com.freecodecloud.composetutorial.presentation.screen.task_list.component.WellnessTasksList
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    ComposeTutorialTheme {
        WellnessScreen()
    }

}