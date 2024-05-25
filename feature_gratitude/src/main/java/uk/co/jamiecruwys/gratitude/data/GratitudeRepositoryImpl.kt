package uk.co.jamiecruwys.gratitude.data

import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
import java.util.Date
import javax.inject.Inject

@Suppress("MagicNumber")
class GratitudeRepositoryImpl
    @Inject
    constructor() : GratitudeRepository {
        private val entries: MutableList<GratitudeEntry> =
            mutableListOf(
                GratitudeEntry("My supportive friends and family", Date(1703376000000)),
                GratitudeEntry("Having good health", Date(1703376000000)),
                GratitudeEntry("A job that I enjoy doing", Date(1703376000000)),
                GratitudeEntry("A place to live in", Date(1703462400000)),
                GratitudeEntry("Being able to express myself freely", Date(1704067200000)),
                GratitudeEntry("Owning books that I can enjoy", Date(1706832000000)),
                GratitudeEntry("The kind things other people do for me", Date(1709424000000)),
                GratitudeEntry("This application", Date(1712185200000)),
                GratitudeEntry("People who download this app", Date(1714863600000)),
                GratitudeEntry("Food", Date()),
            )

        override suspend fun getEntries(): List<GratitudeEntry> = entries.sortedByDescending { it.dateCreated.time }

        override suspend fun addEntry(gratitudeEntry: GratitudeEntry): List<GratitudeEntry> {
            entries.add(gratitudeEntry)
            return getEntries()
        }
    }
