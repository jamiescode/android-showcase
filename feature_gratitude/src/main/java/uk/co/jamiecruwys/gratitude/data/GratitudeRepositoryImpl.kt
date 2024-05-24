package uk.co.jamiecruwys.gratitude.data

import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
import javax.inject.Inject

class GratitudeRepositoryImpl
    @Inject
    constructor() : GratitudeRepository {
        private val entries: MutableList<GratitudeEntry> =
            mutableListOf(
                GratitudeEntry("My supportive friends and family"),
                GratitudeEntry("Having good health"),
                GratitudeEntry("A job that I enjoy doing"),
                GratitudeEntry("A place to live in"),
                GratitudeEntry("Being able to express myself freely"),
                GratitudeEntry("Owning books that I can enjoy"),
                GratitudeEntry("The kind things other people do for me"),
                GratitudeEntry("This application"),
            )

        override suspend fun getEntries(): List<GratitudeEntry> = entries

        override suspend fun addEntry(gratitudeEntry: GratitudeEntry): List<GratitudeEntry> {
            entries.add(gratitudeEntry)
            return entries
        }
    }
