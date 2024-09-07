package com.jamiescode.showcase.gratitude.data

import com.jamiescode.showcase.gratitude.data.database.JournalEntryDao
import com.jamiescode.showcase.gratitude.presentation.domain.model.GratitudeEntry
import com.jamiescode.showcase.gratitude.presentation.domain.toGratitudeEntry
import com.jamiescode.showcase.gratitude.presentation.domain.toJournalEntry
import javax.inject.Inject

class GratitudeRepositoryImpl
    @Inject
    constructor(
        private val journalEntryDao: JournalEntryDao,
    ) : GratitudeRepository {
        override suspend fun getEntries(): List<GratitudeEntry> {
            val dbEntries = journalEntryDao.getAll()
            val domainEntries = dbEntries.map { it.toGratitudeEntry() }
            return domainEntries.sortedByDescending { it.created.time }
        }

        override suspend fun addEntry(gratitudeEntry: GratitudeEntry): List<GratitudeEntry> {
            val dbEntry = gratitudeEntry.toJournalEntry()
            journalEntryDao.add(dbEntry)
            return getEntries()
        }
    }
