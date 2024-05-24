package uk.co.jamiecruwys.gratitude.data

import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry

interface GratitudeRepository {
    suspend fun getEntries(): List<GratitudeEntry>

    suspend fun addEntry(gratitudeEntry: GratitudeEntry): List<GratitudeEntry>
}
