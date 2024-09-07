package com.jamiescode.showcase.gratitude.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface JournalEntryDao {
    @Query("SELECT * FROM journalentry")
    suspend fun getAll(): List<JournalEntry>

    @Insert
    suspend fun add(journalEntry: JournalEntry)

    @Update
    suspend fun update(journalEntry: JournalEntry)

    @Delete
    suspend fun delete(journalEntry: JournalEntry)
}
