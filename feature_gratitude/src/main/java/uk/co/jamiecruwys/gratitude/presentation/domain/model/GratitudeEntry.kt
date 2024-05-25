package uk.co.jamiecruwys.gratitude.presentation.domain.model

import java.util.Date

data class GratitudeEntry(
    val text: String,
    val dateCreated: Date = Date(),
) {
    private val groupDate: GratitudeGroupDate = GratitudeGroupDate()

    fun toDateString(): String = groupDate.toDateString(dateCreated)
}
