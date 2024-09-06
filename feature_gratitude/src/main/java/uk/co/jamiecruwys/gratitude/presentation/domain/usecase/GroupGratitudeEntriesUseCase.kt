package uk.co.jamiecruwys.gratitude.presentation.domain.usecase

import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
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
