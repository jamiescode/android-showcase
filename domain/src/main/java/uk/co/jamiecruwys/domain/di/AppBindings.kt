package uk.co.jamiecruwys.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.jamiecruwys.domain.repository.DogImageRepository
import uk.co.jamiecruwys.domain.repository.DogImageRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface AppBindings {
    @Binds
    fun dogImageRepository(impl: DogImageRepositoryImpl): DogImageRepository
}
