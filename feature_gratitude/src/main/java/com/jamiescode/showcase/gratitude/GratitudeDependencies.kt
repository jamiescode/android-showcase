package com.jamiescode.showcase.gratitude

import com.jamiescode.showcase.gratitude.data.repository.GratitudeRepositoryImpl
import com.jamiescode.showcase.gratitude.domain.repository.GratitudeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface GratitudeDependencies {
    @Binds
    fun provideGratitudeRepository(impl: GratitudeRepositoryImpl): GratitudeRepository
}
