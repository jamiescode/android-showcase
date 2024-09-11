package com.jamiescode.showcase

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber

class TimberInitializer(
    private val isDebug: Boolean = BuildConfig.DEBUG,
) : Initializer<Unit> {
    override fun create(context: Context) {
        if (isDebug) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf()
}
