package uk.co.jamiecruwys.domain.repository

import uk.co.jamiecruwys.domain.model.DogImageDomainModel

interface DogImageRepository {
    suspend fun getRandomImage(): DogImageDomainModel?
}
