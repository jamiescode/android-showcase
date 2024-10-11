package com.jamiescode.showcase.gratitude.domain.model

import java.util.Date
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class GratitudeEntry
    @OptIn(ExperimentalUuidApi::class)
    constructor(
        val id: String = Uuid.random().toString(),
        val entry: String,
        val created: Date = Date(),
        val updated: Date = Date(),
        val tags: List<String> = emptyList(),
    ) {
        private val groupDate: GratitudeGroupDate = GratitudeGroupDate()

        fun toDateString(): String = groupDate.toDateString(created)
    }
