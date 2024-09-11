package com.jamiescode.showcase.gratitude.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Date

class GratitudeEntryTest {
    @Test
    fun `when toDateString, then convert to date string`() {
        // GIVEN
        val gratitudeEntry =
            GratitudeEntry(
                entry = "entry",
                created = Date(1726091949775),
                updated = Date(0L),
                tags = listOf("tag"),
            )

        // WHEN
        val dateString = gratitudeEntry.toDateString()

        // THEN
        assertEquals("2024-09-11", dateString)
    }

    @Test
    fun `when fromDateString, then convert to date`() {
        // GIVEN
        val gratitudeGroupDate = GratitudeGroupDate()

        // WHEN
        val date = gratitudeGroupDate.fromDateString("2024-09-11")
        val dateTime = date?.time ?: 0L

        // THEN
        assertEquals(1726009200000, dateTime)
    }
}
