package com.freecodecloud.composetutorial.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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

// step - Align your element - modifiers

@Composable
fun AlignYourBodyElement(
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "icon",
            contentScale = ContentScale.None,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
        )
        Text(
            text = stringResource(id = R.string.profile_name),
            style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyElementPreview() {
    ComposeTutorialTheme {
        AlignYourBodyElement(modifier = Modifier.padding(8.dp))
    }
}


