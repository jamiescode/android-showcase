package com.jamiescode.showcase.dog.data

import com.jamiescode.showcase.dog.DogQualifier
import com.jamiescode.showcase.dog.data.datasource.api.response.toDomainModel
import com.jamiescode.showcase.dog.data.datasource.api.service.DogImageRetrofitService
import com.jamiescode.showcase.dog.domain.model.DogImage
import javax.inject.Inject

class DogImageRepositoryImpl
    @Inject
    constructor(
        @DogQualifier private val service: DogImageRetrofitService,
    ) : DogImageRepository {
        override suspend fun getImage(): DogImage? = service.getRandomImageAsync()?.toDomainModel()
    }
