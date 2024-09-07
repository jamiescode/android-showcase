package com.jamiescode.showcase.settings.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface SettingsBindings {
    @Binds
    fun settingsRepository(impl: SettingsRepositoryImpl): SettingsRepository
}
