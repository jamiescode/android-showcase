package com.jamiescode.showcase.gratitude.domain.repository

import com.jamiescode.showcase.gratitude.domain.model.GratitudeEntry

interface GratitudeRepository {
    suspend fun getEntries(): List<GratitudeEntry>

    suspend fun addEntry(gratitudeEntry: GratitudeEntry): List<GratitudeEntry>

    suspend fun deleteEntry(gratitudeEntry: GratitudeEntry): List<GratitudeEntry>
}
