package uk.co.jamiecruwys.dog.data

import uk.co.jamiecruwys.dog.data.datasource.api.response.toDomainModel
import uk.co.jamiecruwys.dog.data.datasource.api.service.DogImageRetrofitService
import uk.co.jamiecruwys.dog.domain.model.DogImage
import javax.inject.Inject

class DogImageRepositoryImpl
    @Inject
    constructor(
        private val service: DogImageRetrofitService,
    ) : DogImageRepository {
        override suspend fun getImage(): DogImage? = service.getRandomImageAsync()?.toDomainModel()
    }
