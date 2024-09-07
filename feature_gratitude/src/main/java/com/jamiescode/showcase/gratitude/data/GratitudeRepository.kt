package com.jamiescode.showcase.gratitude.data

import com.jamiescode.showcase.gratitude.presentation.domain.model.GratitudeEntry

interface GratitudeRepository {
    suspend fun getEntries(): List<GratitudeEntry>

    suspend fun addEntry(gratitudeEntry: GratitudeEntry): List<GratitudeEntry>
}
