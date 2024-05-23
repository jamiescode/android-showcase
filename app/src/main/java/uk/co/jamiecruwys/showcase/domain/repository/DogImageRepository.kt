package uk.co.jamiecruwys.showcase.domain.repository

import uk.co.jamiecruwys.showcase.domain.model.DogImageDomainModel

interface DogImageRepository {
    suspend fun getRandomImage(): DogImageDomainModel?
}
