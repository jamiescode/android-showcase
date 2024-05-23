package uk.co.jamiecruwys.domain.repository

import uk.co.jamiecruwys.domain.retrofit.DogImageRetrofitService
import uk.co.jamiecruwys.domain.retrofit.toDomainModel
import javax.inject.Inject

class DogImageRepositoryImpl
    @Inject
    constructor(
        private val dogImageRetrofitService: DogImageRetrofitService,
    ) : DogImageRepository {
        override suspend fun getRandomImage(): uk.co.jamiecruwys.domain.model.DogImageDomainModel? {
            return dogImageRetrofitService.getRandomImageAsync()?.toDomainModel()
        }
    }
