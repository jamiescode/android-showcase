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
                if (isUnsupportedFileType(it.imageUrl)) {
                    Result.Error(java.lang.RuntimeException("Unsupported file type"))
                } else {
                    Result.Success(it.imageUrl)
                }
            } ?: Result.Error(RuntimeException("No image url"))
        } catch (e: IOException) {
            Result.Error(e)
        }
    }

    private fun isUnsupportedFileType(imageUrl: String): Boolean {
        return imageUrl.endsWith(".mp4", ignoreCase = true) || imageUrl.endsWith(
            ".webm",
            ignoreCase = true
        )
    }
}