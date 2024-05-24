package uk.co.jamiecruwys.dog.domain.usecase

import java.io.IOException
import javax.inject.Inject

class GetDogImageUseCase
    @Inject
    constructor(
        private val dogImageRepository: uk.co.jamiecruwys.dog.data.DogImageRepository,
    ) {
        sealed class Result {
            data class Success(val imageUrl: String) : Result()

            data class Error(val e: Throwable) : Result()
        }

        suspend fun execute(): Result {
            return try {
                dogImageRepository.getRandomImage()?.let {
                    Result.Success(it.imageUrl)
                } ?: Result.Error(RuntimeException("No image url"))
            } catch (e: IOException) {
                Result.Error(e)
            }
        }
    }
