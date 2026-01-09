package com.hellokmp.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import com.hellokmp.shared.App
import com.hellokmp.shared.backgroundModifier
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val app = document.getElementById(elementId = "app") ?: return
    ComposeViewport(viewportContainer = app) {
        App(modifier = Modifier.backgroundModifier())
    }
}