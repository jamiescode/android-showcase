package com.jamiescode.showcase.gratitude.data.repository

import com.jamiescode.showcase.gratitude.data.database.JournalEntry
import com.jamiescode.showcase.gratitude.data.database.JournalEntryDao
import com.jamiescode.showcase.gratitude.domain.model.GratitudeEntry
import com.jamiescode.showcase.gratitude.domain.toGratitudeEntry
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
        val id = "1234567890"
        val journalEntry1 = JournalEntry(id = id, created = 0L, updated = 0L, entry = "", tags = "tag")
        val journalEntries = listOf(journalEntry1)
        coEvery { journalEntryDao.getAll() }.returns(journalEntries)

        // WHEN
        val entries = runBlocking { repository.getEntries() }

        // THEN
        val expectedGratitudeEntry =
            GratitudeEntry(
                id = id,
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
                id = "1234567890",
                created = 100L,
                updated = 200L,
                entry = "entry",
                tags = "tag",
            )
        coEvery { journalEntryDao.add(journalEntry) }.returns(Unit)
        coEvery { journalEntryDao.getAll() }.returns(listOf(journalEntry))

        // WHEN
        val gratitudeEntry = journalEntry.toGratitudeEntry()
        val entries = runBlocking { repository.addEntry(gratitudeEntry) }
        coVerify { journalEntryDao.add(journalEntry) }

        assertEquals(listOf(gratitudeEntry), entries)
    }
}
