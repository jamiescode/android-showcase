package com.jamiescode.showcase.gratitude.data.database

import android.content.Context
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class JournalEntryDependenciesTest {
    @Test
    fun createJournalEntryDatabase() {
        val context: Context = mockk(relaxed = true)
        val database = JournalEntryDependencies.provideJournalEntryDatabase(context)
        assertNotNull(database)
    }

    @Test
    fun createDogImageRetrofitService() {
        val database: JournalEntryDatabase = mockk(relaxed = true)
        val journalEntryDao = JournalEntryDependencies.provideJournalEntryDao(database)
        assertNotNull(journalEntryDao)
    }
}
