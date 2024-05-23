package uk.co.jamiecruwys.domain.repository

import uk.co.jamiecruwys.domain.model.DogImageDomainModel
import uk.co.jamiecruwys.domain.retrofit.DogImageRetrofitService
import uk.co.jamiecruwys.domain.retrofit.toDomainModel
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
