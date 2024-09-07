package com.jamiescode.showcase.dog.data

import com.jamiescode.showcase.dog.domain.model.DogImage

interface DogImageRepository {
    suspend fun getImage(): DogImage?
}
