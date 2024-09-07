package com.jamiescode.showcase.dog.domain.repository

import com.jamiescode.showcase.dog.domain.model.DogImage

interface DogImageRepository {
    suspend fun getImage(): DogImage?
}
