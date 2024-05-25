package uk.co.jamiecruwys.gratitude.presentation.domain

import uk.co.jamiecruwys.gratitude.data.database.JournalEntry
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
import java.util.Date

private const val TAGS_SEPARATOR = ","

fun JournalEntry.toGratitudeEntry() =
    GratitudeEntry(
        entry = entry,
        created = Date(created),
        updated = Date(updated),
        tags = tags.split(TAGS_SEPARATOR),
    )

fun GratitudeEntry.toJournalEntry() =
    JournalEntry(
        created = created.time,
        updated = updated.time,
        entry = entry,
        tags = tags.joinToString(separator = TAGS_SEPARATOR),
    )
