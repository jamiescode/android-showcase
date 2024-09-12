package com.jamiescode.showcase

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class AppTest {
    @Test
    fun checkApp() {
        // WHEN
        val app = App()

        // THEN
        assertNotNull(app)
    }
}
