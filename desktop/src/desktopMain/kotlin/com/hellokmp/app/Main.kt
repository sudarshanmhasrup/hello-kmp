package com.hellokmp.app

import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.hellokmp.shared.App
import com.hellokmp.shared.backgroundModifier

fun main() {
    application {
        Window(onCloseRequest = ::exitApplication) {
            App(modifier = Modifier.backgroundModifier())
        }
    }
}