package com.jamiescode.showcase.gratitude.data.repository

import com.jamiescode.showcase.gratitude.data.database.JournalEntry
import com.jamiescode.showcase.gratitude.data.database.JournalEntryDao
import com.jamiescode.showcase.gratitude.domain.model.GratitudeEntry
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Date

class GratitudeRepositoryImplTest {
    private val journalEntryDao: JournalEntryDao = mockk(relaxed = true)
    private val repository = GratitudeRepositoryImpl(journalEntryDao)

    @Test
    fun `when get entries call, then return entries from database`() {
        // GIVEN
        val journalEntry1 = JournalEntry(created = 0L, updated = 0L, entry = "", tags = "tag")
        val journalEntries = listOf(journalEntry1)
        coEvery { journalEntryDao.getAll() }.returns(journalEntries)

        // WHEN
        val entries = runBlocking { repository.getEntries() }

        // THEN
        val expectedGratitudeEntry =
            GratitudeEntry(
                entry = journalEntry1.entry,
                created = Date(journalEntry1.created),
                updated = Date(journalEntry1.updated),
                tags = listOf("tag"),
            )
        assertEquals(listOf(expectedGratitudeEntry), entries)
    }

    @Test
    fun `when addEntry, then add entry to database`() {
        // GIVEN
        val journalEntry =
            JournalEntry(
                created = 100L,
                updated = 200L,
                entry = "entry",
                tags = "tag",
            )
        coEvery { journalEntryDao.add(journalEntry) }.returns(Unit)

        val journalEntry1 = JournalEntry(created = 0L, updated = 0L, entry = "", tags = "tag")
        val journalEntries = listOf(journalEntry1)
        coEvery { journalEntryDao.getAll() }.returns(journalEntries)

        // WHEN
        val gratitudeEntry =
            GratitudeEntry(
                entry = "entry",
                created = Date(100L),
                updated = Date(200L),
                tags = listOf("tag"),
            )
        val entries = runBlocking { repository.addEntry(gratitudeEntry) }
        coVerify { journalEntryDao.add(journalEntry) }

        val expectedGratitudeEntry =
            GratitudeEntry(
                entry = journalEntry1.entry,
                created = Date(journalEntry1.created),
                updated = Date(journalEntry1.updated),
                tags = listOf("tag"),
            )
        assertEquals(listOf(expectedGratitudeEntry), entries)
    }
}
