package com.jamiescode

import android.app.Application
import android.content.Context
import com.karumi.shot.ShotTestRunner
import dagger.hilt.android.testing.HiltTestApplication

class GratitudeTestRunner : ShotTestRunner() {
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}
