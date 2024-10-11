package com.jamiescode.showcase.gratitude.domain

import com.jamiescode.showcase.gratitude.data.database.JournalEntry
import com.jamiescode.showcase.gratitude.domain.model.GratitudeEntry
import java.util.Date

private const val TAGS_SEPARATOR = ","

fun JournalEntry.toGratitudeEntry() =
    GratitudeEntry(
        id = id,
        entry = entry,
        created = Date(created),
        updated = Date(updated),
        tags = tags.split(TAGS_SEPARATOR),
    )

fun GratitudeEntry.toJournalEntry() =
    JournalEntry(
        id = id,
        created = created.time,
        updated = updated.time,
        entry = entry,
        tags = tags.joinToString(separator = TAGS_SEPARATOR),
    )
