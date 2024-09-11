package com.jamiescode.showcase.gratitude.data.database

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class JournalEntryTest {
    @Test
    fun `database name is correct`() {
        val databaseName = JournalEntryDatabase.Companion.NAME
        assertEquals("journal-entry", databaseName)
    }

    @Test
    fun `database version is correct`() {
        val journalEntry =
            JournalEntry(
                created = 100L,
                updated = 200L,
                entry = "entry",
                tags = "tag",
            )
        assertEquals(100L, journalEntry.created)
        assertEquals(200L, journalEntry.updated)
        assertEquals("entry", journalEntry.entry)
        assertEquals("tag", journalEntry.tags)
    }

    @Test
    fun `database creation`() {
        val journalEntryDatabase =
            object : JournalEntryDatabase() {
                override fun journalEntryDao(): JournalEntryDao = mockk(relaxed = true)

                override fun clearAllTables() {}

                override fun createInvalidationTracker(): InvalidationTracker = InvalidationTracker(database = this)

                override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper = mockk(relaxed = true)
            }
        assertNotNull(journalEntryDatabase)
    }
}
