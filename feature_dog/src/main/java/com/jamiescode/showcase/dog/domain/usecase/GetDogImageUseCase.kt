package com.jamiescode.showcase.dog.domain.usecase

import com.jamiescode.showcase.dog.data.DogImageRepository
import java.io.IOException
import javax.inject.Inject

class GetDogImageUseCase
    @Inject
    constructor(
        private val dogImageRepository: DogImageRepository,
    ) {
        sealed class Result {
            data class Success(
                val imageUrl: String,
            ) : Result()

            data class Error(
                val e: Throwable,
            ) : Result()
        }

        suspend fun execute(): Result =
            try {
                dogImageRepository.getImage()?.let {
                    Result.Success(it.imageUrl)
                } ?: Result.Error(RuntimeException("No image url"))
            } catch (e: IOException) {
                Result.Error(e)
            }
    }
