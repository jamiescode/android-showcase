package com.jamiescode.showcase.dog

import com.jamiescode.showcase.dog.data.DogImageRepository
import com.jamiescode.showcase.dog.data.DogImageRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DogBindings {
    @Binds
    fun dogImageRepository(impl: DogImageRepositoryImpl): DogImageRepository
}
