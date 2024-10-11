package com.jamiescode.showcase.gratitude.domain.usecase

import com.jamiescode.showcase.gratitude.domain.model.GratitudeEntry
import com.jamiescode.showcase.gratitude.domain.repository.GratitudeRepository
import javax.inject.Inject

class DeleteGratitudeEntryUseCase
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
            val entries = gratitudeRepository.deleteEntry(gratitudeEntry)
            val groupedEntries = groupGratitudeEntriesUseCase.execute(entries)
            return Result.Success(groupedEntries)
        }
    }
