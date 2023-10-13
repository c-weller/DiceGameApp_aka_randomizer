package com.example.randomizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.sp
import com.example.randomizer.ui.theme.RandomizerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomizerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceGameApp()
                }
            }
        }
    }
}


@Preview
@Composable
fun DiceGameApp() {
    DiceGame(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceGame(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf( 1) }
    val textResource = when(result) {
        1 -> R.string.item1
        2 -> R.string.item2
        3 -> R.string.item3
        4 -> R.string.item4
        5 -> R.string.item5
        6 -> R.string.item6
        7 -> R.string.item7
        8 -> R.string.item8
        9 -> R.string.item9
        else -> R.string.item10
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(stringResource(id = textResource))

        Button(
            onClick = { result = (1..6).random() },
            ) {
            Text(text = stringResource(R.string.button_text), fontSize = 24.sp)
        }
    }
}
