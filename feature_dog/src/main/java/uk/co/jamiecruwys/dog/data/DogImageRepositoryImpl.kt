package uk.co.jamiecruwys.dog.data

import uk.co.jamiecruwys.dog.data.datasource.api.response.toDomainModel
import uk.co.jamiecruwys.dog.domain.model.DogImage
import uk.co.jamiecruwys.dog.data.datasource.api.service.DogImageRetrofitService
import javax.inject.Inject

class DogImageRepositoryImpl
    @Inject
    constructor(
        private val dogImageRetrofitService: DogImageRetrofitService,
    ) : DogImageRepository {
        override suspend fun getRandomImage(): DogImage? {
            return dogImageRetrofitService.getRandomImageAsync()?.toDomainModel()
        }
    }
