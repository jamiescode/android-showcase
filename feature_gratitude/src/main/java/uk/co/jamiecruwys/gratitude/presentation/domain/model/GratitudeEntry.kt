package uk.co.jamiecruwys.gratitude.presentation.domain.model

import java.util.Date

data class GratitudeEntry(
    val entry: String,
    val created: Date = Date(),
    val updated: Date = Date(),
    val tags: List<String> = emptyList(),
) {
    private val groupDate: GratitudeGroupDate = GratitudeGroupDate()

    fun toDateString(): String = groupDate.toDateString(created)
}
