package uk.co.jamiecruwys.showcase.settings.data

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore("settings")

class DataStoreManager
    @Inject
    constructor(
        @ApplicationContext appContext: Context,
    ) {
        private val settingsDataStore = appContext.dataStore

        fun get() = settingsDataStore
    }
