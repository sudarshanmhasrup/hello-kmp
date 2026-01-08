package com.hellokmp.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.backgroundModifier(): Modifier {
    return this
        .fillMaxSize()
        .padding(all = 20.dp)
}