package io.github.sudarshanmhasrup.hellokmp

import kotlin.test.Test
import kotlin.test.assertEquals

class JvmPlatformTest {
    @Test
    fun testJvmPlatformName() {
        val platform = Platform()
        val expectedResult = "JVM ${System.getProperty("java.version")}"
        val actualResult = platform.getPlatformName()

        assertEquals(expected = expectedResult, actual = actualResult)
    }
}