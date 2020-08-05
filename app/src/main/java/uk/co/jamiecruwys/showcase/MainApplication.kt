package uk.co.jamiecruwys.showcase

import android.app.Application
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class MainApplication : Application(), DIAware {
    override val di by DI.lazy {
        import(androidXModule(this@MainApplication))
        import(mainModule)
    }
}