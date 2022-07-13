package uk.co.jamiecruwys.showcase.domain.usecase

import uk.co.jamiecruwys.showcase.domain.repository.DogImageRepository
import java.io.IOException

class GetDogImageUseCase(
    private val dogImageRepository: DogImageRepository
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
