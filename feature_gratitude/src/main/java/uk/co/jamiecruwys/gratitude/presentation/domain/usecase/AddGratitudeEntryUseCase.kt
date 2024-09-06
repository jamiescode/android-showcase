package uk.co.jamiecruwys.gratitude.presentation.domain.usecase

import uk.co.jamiecruwys.gratitude.data.GratitudeRepository
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
import javax.inject.Inject

class AddGratitudeEntryUseCase
    @Inject
    constructor(
        private val gratitudeRepository: GratitudeRepository,
        private val groupGratitudeEntriesUseCase: GroupGratitudeEntriesUseCase,
    ) {
        sealed class Result {
            data class Success(
                val gratitudeEntries: Map<String, List<GratitudeEntry>>,
            ) : Result()

            data class Error(
                val e: Throwable,
            ) : Result()
        }

        suspend fun execute(gratitudeEntry: GratitudeEntry): Result {
            val entries = gratitudeRepository.addEntry(gratitudeEntry)
            val groupedEntries = groupGratitudeEntriesUseCase.execute(entries)
            return Result.Success(groupedEntries)
        }
    }
