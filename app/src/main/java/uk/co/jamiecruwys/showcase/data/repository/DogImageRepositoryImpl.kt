package uk.co.jamiecruwys.showcase.data.repository

import uk.co.jamiecruwys.showcase.data.retrofit.response.toDomainModel
import uk.co.jamiecruwys.showcase.data.retrofit.service.DogImageRetrofitService
import uk.co.jamiecruwys.showcase.domain.model.DogImageDomainModel
import uk.co.jamiecruwys.showcase.domain.repository.DogImageRepository
import javax.inject.Inject

class DogImageRepositoryImpl
    @Inject
    constructor(
        private val dogImageRetrofitService: DogImageRetrofitService,
    ) : DogImageRepository {
        override suspend fun getRandomImage(): DogImageDomainModel? {
            return dogImageRetrofitService.getRandomImageAsync()?.toDomainModel()
        }
    }
