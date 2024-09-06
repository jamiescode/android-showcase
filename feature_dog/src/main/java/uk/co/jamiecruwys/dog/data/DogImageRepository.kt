package uk.co.jamiecruwys.dog.data

import uk.co.jamiecruwys.dog.domain.model.DogImage

interface DogImageRepository {
    suspend fun getImage(): DogImage?
}
