package uk.co.jamiecruwys.showcase.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.jamiecruwys.showcase.data.repository.DogImageRepositoryImpl
import uk.co.jamiecruwys.showcase.domain.repository.DogImageRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppBindings {

    @Binds
    fun dogImageRepository(impl: DogImageRepositoryImpl): DogImageRepository
}
