package uk.co.jamiecruwys.dog

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.jamiecruwys.dog.data.DogImageRepository
import uk.co.jamiecruwys.dog.data.DogImageRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DogBindings {
    @Binds
    fun dogImageRepository(impl: uk.co.jamiecruwys.dog.data.DogImageRepositoryImpl): uk.co.jamiecruwys.dog.data.DogImageRepository
}
