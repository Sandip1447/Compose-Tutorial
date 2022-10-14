package com.freecodecloud.composetutorial.presentation.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freecodecloud.composetutorial.R
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme


// https://developer.android.com/codelabs/jetpack-compose-layouts#0


// Step - SearchBar - Modifiers
@Composable
fun SearchBar(
    modifier: Modifier
) {

    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        placeholder = {
            Text(text = stringResource(id = R.string.placeholder_search))
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier = modifier
            .heightIn(min = 54.dp)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    ComposeTutorialTheme {
        SearchBar(modifier = Modifier.padding(8.dp))
    }

}