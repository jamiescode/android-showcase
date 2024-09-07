package com.jamiescode.showcase.gratitude.presentation.domain.usecase

import com.jamiescode.showcase.gratitude.presentation.domain.model.GratitudeEntry
import javax.inject.Inject

class GroupGratitudeEntriesUseCase
    @Inject
    constructor() {
        fun execute(entries: List<GratitudeEntry>): Map<String, List<GratitudeEntry>> =
            entries
                .groupBy {
                    it.toDateString()
                }.toSortedMap(Comparator.reverseOrder())
    }
