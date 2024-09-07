package com.jamiescode.showcase.gratitude.domain.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
class GratitudeGroupDate {
    fun toDateString(date: Date): String = SimpleDateFormat(PATTERN).format(date)

    fun fromDateString(string: String): Date? = SimpleDateFormat(PATTERN).parse(string)

    companion object {
        private const val PATTERN = "yyyy-MM-dd"
    }
}
