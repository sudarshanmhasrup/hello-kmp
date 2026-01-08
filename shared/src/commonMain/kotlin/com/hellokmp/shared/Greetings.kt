package com.hellokmp.shared

import io.github.sudarshanmhasrup.hellokmp.Platform

class Greetings {
    fun getGreeting(): String {
        val platform = Platform()
        return "Hello there, you're reading this text on ${platform.getPlatformName()}."
    }
}