package com.jamiescode.showcase.dog.data.repository

import com.jamiescode.showcase.dog.data.datasource.api.response.DogImageResponse
import com.jamiescode.showcase.dog.data.datasource.api.service.DogImageRetrofitService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class DogImageRepositoryImplTest {
    private val retrofitService: DogImageRetrofitService = mockk(relaxed = true)
    private val repository = DogImageRepositoryImpl(retrofitService)

    @Test
    fun `given response, when get image is called, then image url returned`() {
        // GIVEN DogImageResponse
        val imageResponse: DogImageResponse = listOf("1.png")
        coEvery { retrofitService.getRandomImageAsync() }.returns(imageResponse)

        // WHEN getImage is called
        val result = runBlocking { repository.getImage() }

        // THEN getRandomImageAsync called on DogImageRetrofitService
        coVerify { retrofitService.getRandomImageAsync() }

        // THEN imageUrl is correct
        val imageUrl = result?.imageUrl
        assertEquals("https://random.dog/1.png", imageUrl)
    }

    @Test
    fun `given null response, when get image is called, then null returned`() {
        // GIVEN DogImageResponse
        coEvery { retrofitService.getRandomImageAsync() }.returns(null)

        // WHEN getImage is called
        val result = runBlocking { repository.getImage() }

        // THEN getRandomImageAsync called on DogImageRetrofitService
        coVerify { retrofitService.getRandomImageAsync() }

        // THEN imageUrl is null
        val imageUrl = result?.imageUrl
        assertNull(imageUrl)
    }
}
