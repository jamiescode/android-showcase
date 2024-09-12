package com.jamiescode.showcase.gratitude.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JournalEntry::class], version = 1)
abstract class JournalEntryDatabase : RoomDatabase() {
    abstract fun journalEntryDao(): JournalEntryDao

    companion object {
        const val NAME = "journal-entry"
    }
}
