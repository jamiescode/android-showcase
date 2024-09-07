package com.jamiescode.showcase.settings.data

import com.jamiescode.showcase.settings.data.repository.SettingsRepositoryImpl
import com.jamiescode.showcase.settings.domain.repository.SettingsRepository
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
