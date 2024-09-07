package com.jamiescode.showcase

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber
import com.jamiescode.showcase.BuildConfig

class TimberInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf()
}
