package uk.co.jamiecruwys.gratitude.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class JournalEntry(
    @PrimaryKey val created: Long,
    @ColumnInfo(name = "updated") val updated: Long,
    @ColumnInfo(name = "entry") val entry: String,
    @ColumnInfo(name = "tags") val tags: String,
)
