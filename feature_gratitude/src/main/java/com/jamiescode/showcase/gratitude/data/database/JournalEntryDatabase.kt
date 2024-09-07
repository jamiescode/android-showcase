package com.jamiescode.showcase.gratitude.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.jamiescode.showcase.gratitude.data.database.JournalEntry::class], version = 1)
abstract class JournalEntryDatabase : RoomDatabase() {
    abstract fun journalEntryDao(): com.jamiescode.showcase.gratitude.data.database.JournalEntryDao

    companion object {
        const val NAME = "journal-entry"
    }
}
