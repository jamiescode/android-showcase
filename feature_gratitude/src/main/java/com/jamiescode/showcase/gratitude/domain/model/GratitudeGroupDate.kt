package com.jamiescode.showcase.gratitude.domain.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@SuppressLint("SimpleDateFormat")
class GratitudeGroupDate {
    private val simpleDateFormat: SimpleDateFormat = SimpleDateFormat(PATTERN)

    init {
        simpleDateFormat.timeZone = TimeZone.getTimeZone(TIMEZONE)
    }

    fun toDateString(date: Date): String = simpleDateFormat.format(date)

    fun fromDateString(string: String): Date? = simpleDateFormat.parse(string)

    companion object {
        private const val PATTERN = "yyyy-MM-dd"
        private const val TIMEZONE = "UTC"
    }
}
