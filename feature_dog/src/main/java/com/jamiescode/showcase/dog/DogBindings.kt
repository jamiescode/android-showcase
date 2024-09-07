package com.jamiescode.showcase.dog

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.jamiescode.showcase.dog.data.DogImageRepository
import com.jamiescode.showcase.dog.data.DogImageRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DogBindings {
    @Binds
    fun dogImageRepository(impl: DogImageRepositoryImpl): DogImageRepository
}
