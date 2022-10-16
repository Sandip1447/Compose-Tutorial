package com.freecodecloud.composetutorial.presentation.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes text: Int
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = drawable),
            contentDescription = "icon",
            contentScale = ContentScale.None,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
        )
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyElementPreview() {
    ComposeTutorialTheme {
        AlignYourBodyElement(
            modifier = Modifier.padding(8.dp),
            R.drawable.ic_launcher_background,
            R.string.profile_name
        )
    }
}

// step  - FavouriteCollectionCard - modifiers

@Composable
fun FavouriteCollectionCard(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    @StringRes text: Int
) {

    Surface(modifier = modifier, shape = MaterialTheme.shapes.small) {
        Row(modifier = Modifier.width(192.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(id = drawable),
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FavouriteCollectionCardPreview() {

    ComposeTutorialTheme {
        FavouriteCollectionCard(
            modifier = Modifier.padding(8.dp),
            R.drawable.ic_launcher_background, R.string.dummy_title
        )
    }
}


// Dummy list data
private val alignYourBodyData = listOf(
    R.drawable.ic_launcher_background to R.string.dummy_title,
    R.drawable.ic_launcher_background to R.string.dummy_title,
    R.drawable.ic_launcher_background to R.string.dummy_title,
    R.drawable.ic_launcher_background to R.string.dummy_title,
    R.drawable.ic_launcher_background to R.string.dummy_title,
    R.drawable.ic_launcher_background to R.string.dummy_title,
    R.drawable.ic_launcher_background to R.string.dummy_title,
).map {
    DrawableStringPair(it.first, it.second)
}

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

// Step - Align your body row - Arrangements

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyRowPreview() {

    ComposeTutorialTheme {
        AlignYourBodyRow()
    }

}

