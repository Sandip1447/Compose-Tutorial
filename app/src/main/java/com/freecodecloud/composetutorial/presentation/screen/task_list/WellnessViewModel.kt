package com.freecodecloud.composetutorial.presentation.screen.task_list

import androidx.lifecycle.ViewModel
import com.freecodecloud.composetutorial.domain.WellnessTask

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableList()

    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
