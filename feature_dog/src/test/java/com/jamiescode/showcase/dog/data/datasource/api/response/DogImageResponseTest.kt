package com.jamiescode.showcase.dog.data.datasource.api.response

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DogImageResponseTest {
    private val baseImageUrl = "https://random.dog/"

    @Test
    fun `given response, when converted to domain model, filter out mp4 files`() {
        // GIVEN a response
        val response = listOf("1.png", "2.mp4")
        // WHEN converted to domain model
        val domainModel = response.toDomainModel()
        // THEN filter out MP4 files
        assertEquals("${baseImageUrl}1.png", domainModel.imageUrl)
    }

    @Test
    fun `given response, when converted to domain model, filter out webm files`() {
        // GIVEN a response
        val response = listOf("1.png", "2.webm")
        // WHEN converted to domain model
        val domainModel = response.toDomainModel()
        // THEN filter out MP4 files
        assertEquals("${baseImageUrl}1.png", domainModel.imageUrl)
    }

    @Test
    fun `given response, when converted to domain model, allow png files`() {
        // GIVEN a response
        val response = listOf("1.png")
        // WHEN converted to domain model
        val domainModel = response.toDomainModel()
        // THEN filter out MP4 files
        assertEquals("${baseImageUrl}1.png", domainModel.imageUrl)
    }

    @Test
    fun `given response, when converted to domain model, allow jpg files`() {
        // GIVEN a response
        val response = listOf("1.jpg")
        // WHEN converted to domain model
        val domainModel = response.toDomainModel()
        // THEN filter out MP4 files
        assertEquals("${baseImageUrl}1.jpg", domainModel.imageUrl)
    }

    @Test
    fun `given response, when converted to domain model, allow jpeg files`() {
        // GIVEN a response
        val response = listOf("1.jpeg")
        // WHEN converted to domain model
        val domainModel = response.toDomainModel()
        // THEN filter out MP4 files
        assertEquals("${baseImageUrl}1.jpeg", domainModel.imageUrl)
    }

    @Test
    fun `given response, when converted to domain model, allow gif files`() {
        // GIVEN a response
        val response = listOf("1.gif")
        // WHEN converted to domain model
        val domainModel = response.toDomainModel()
        // THEN filter out MP4 files
        assertEquals("${baseImageUrl}1.gif", domainModel.imageUrl)
    }
}
