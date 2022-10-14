package com.freecodecloud.composetutorial.presentation.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freecodecloud.composetutorial.presentation.ui.theme.ComposeTutorialTheme

@Composable
fun StartupApp() {
    // TODO: This state should be hoisted
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnBoardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }

}


@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit) {

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to Basics of Compose tutorial")
            Button(
                onClick = onContinueClicked,
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(text = "Continue")
            }
        }
    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun OnBoardingScreenPreview() {

    ComposeTutorialTheme {
        OnBoardingScreen(onContinueClicked = {})
    }
}


@Composable
fun Greetings(names: List<String> = List(10) { "$it" }) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Column {
            LazyColumn {
                items(names) { name ->
                    Greeting(name = name)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
fun CardContent(name: String) {

    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )

            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }

        IconButton(onClick = { expanded = !expanded }) {

            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    "Show less"
                } else {
                    "Show more"
                }
            )

        }

    }

}

@Preview(showBackground = true, widthDp = 480, heightDp = 1280)
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        Greetings()
    }
}