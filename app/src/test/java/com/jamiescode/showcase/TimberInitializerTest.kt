package com.jamiescode.showcase

import android.content.Context
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class TimberInitializerTest {
    private val timberInitializer = TimberInitializer()
    private val context: Context = mockk(relaxed = true)

    @Test
    fun `when onCreate then plant tree`() {
        // WHEN
        timberInitializer.create(context)

        // THEN
        assertNotNull(timberInitializer)
    }

    @Test
    fun `when dependencies then return empty list`() {
        // WHEN
        val dependencies = timberInitializer.dependencies()

        // THEN
        assertEquals(0, dependencies.size)
    }
}
