package com.freecodecloud.composetutorial.presentation.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
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
import java.util.*


// https://developer.android.com/codelabs/jetpack-compose-layouts#0


// Step - SearchBar - Modifiers
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
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

// step - Favorite collections grid - Lazy grids

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.height(120.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(alignYourBodyData) { item ->
            FavouriteCollectionCard(drawable = item.drawable, text = item.text)
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFFFEB3B)
@Composable
fun FavoriteCollectionsGridPreview() {

    ComposeTutorialTheme {
        FavoriteCollectionsGrid()
    }
}

// step - Home section - Slot APIs

@Composable
fun HomeSection(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    content: @Composable () -> Unit // You can pass any composable here
) {

    Column(modifier = modifier) {
        Text(
            text = stringResource(id = title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFFFEB3B)
@Composable
fun HomeSectionPreview() {
    ComposeTutorialTheme {
        HomeSection(title = R.string.dummy_title) {
            AlignYourBodyRow() // in our case we will be passing AlignYourBodyRow()
        }
    }
}

// step - Home Screen - Scrolling

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.dummy_title) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.dummy_title) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFFFEB3B)
@Composable
fun HomeScreenPreview() {

    ComposeTutorialTheme {
        HomeScreen()
    }
}

// step - Bottom navigation - Material

@Composable
fun SmoothBottomNavigation(modifier: Modifier = Modifier) {

    BottomNavigation(modifier) {

        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            },
            label = {
                Text(text = stringResource(id = R.string.dummy_title))
            }
        )

        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
            },
            label = {
                Text(text = stringResource(id = R.string.dummy_title))
            }
        )

        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            },
            label = {
                Text(text = stringResource(id = R.string.dummy_title))
            }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFEB3B)
@Composable
fun SmoothBottomNavigationPreview() {
    ComposeTutorialTheme {
        SmoothBottomNavigation()
    }
}

// step - LayoutBasicApp - Scaffold

@Composable
fun LayoutBasicApp() {
    Scaffold(
        bottomBar = { SmoothBottomNavigationPreview() }
    ) { padding ->
        HomeScreen(Modifier.padding(padding))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFEB3B, widthDp = 360, heightDp = 720)
@Composable
fun LayoutBasicAppPreview() {
    ComposeTutorialTheme {
        LayoutBasicApp()
    }
}