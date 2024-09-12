package com.jamiescode.showcase.dog.domain.usecase

import com.jamiescode.showcase.dog.domain.model.DogImage
import com.jamiescode.showcase.dog.domain.repository.DogImageRepository
import com.jamiescode.showcase.dog.domain.usecase.GetDogImageUseCase.Result
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.IOException

class GetDogImageUseCaseTest {
    val dogImageRepository: DogImageRepository = mockk()
    val dogImageUseCase = GetDogImageUseCase(dogImageRepository)

    @Test
    fun `given dog image use case, when execute use case, then success returned`() {
        // GIVEN dog image use case
        val imageUrl = "imageUrl"
        val dogImage = DogImage(imageUrl)
        coEvery { dogImageRepository.getImage() }.returns(dogImage)

        // WHEN execute use case
        val result = runBlocking { dogImageUseCase.execute() }

        // THEN success returned
        assertEquals(Result.Success(imageUrl), result)
    }

    @Test
    fun `given null dog image use case, when execute use case, then success returned`() {
        // GIVEN dog image use case
        coEvery { dogImageRepository.getImage() }.returns(null)

        // WHEN execute use case
        val result = runBlocking { dogImageUseCase.execute() }

        // THEN error returned
        result.shouldBeInstanceOf<Result.Error>()
    }

    @Test
    fun `given io exception, when execute use case, then error returned`() {
        // GIVEN dog image use case
        val exception = IOException()
        coEvery { dogImageRepository.getImage() }.throws(exception)

        // WHEN execute use case
        val result = runBlocking { dogImageUseCase.execute() }

        // THEN error returned
        assertEquals(Result.Error(exception), result)
    }
}
