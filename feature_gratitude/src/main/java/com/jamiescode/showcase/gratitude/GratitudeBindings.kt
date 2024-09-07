package com.jamiescode.showcase.gratitude

import com.jamiescode.showcase.gratitude.data.GratitudeRepository
import com.jamiescode.showcase.gratitude.data.GratitudeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface GratitudeBindings {
    @Binds
    fun gratitudeRepository(impl: GratitudeRepositoryImpl): GratitudeRepository
}
