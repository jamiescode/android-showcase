package com.jamiescode.showcase.gratitude.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JournalEntryDependencies {
    @Singleton
    @Provides
    fun provideJournalEntryDatabase(
        @ApplicationContext appContext: Context,
    ): JournalEntryDatabase =
        Room
            .databaseBuilder(
                context = appContext,
                klass = JournalEntryDatabase::class.java,
                name = JournalEntryDatabase.NAME,
            ).build()

    @Provides
    fun provideJournalEntryDao(database: JournalEntryDatabase): JournalEntryDao = database.journalEntryDao()
}
