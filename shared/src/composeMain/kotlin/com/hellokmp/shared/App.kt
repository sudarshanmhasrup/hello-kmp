package com.hellokmp.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import io.github.sudarshanmhasrup.hellokmp.Platform
import io.github.sudarshanmhasrup.hellokmp.PlatformType

@Composable
fun App(modifier: Modifier = Modifier) {
    val greetings = Greetings()
    val message = greetings.getMessage()

    val platform = Platform()
    val platformType = platform.getPlatformType()

    val formattedText = buildAnnotatedString {
        val startingIndex = message.indexOf(
            string = when (platformType) {
                PlatformType.Android -> "Android"
                PlatformType.Desktop -> "JVM"
                PlatformType.Wasm -> "Kotlin/WASM"
                else -> "null"
            }
        )
        if (startingIndex >= 0) {
            addStyle(
                style = SpanStyle(fontWeight = FontWeight.Bold),
                start = startingIndex,
                end = message.lastIndex
            )
        }
        append(message)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = formattedText,
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )
    }
}