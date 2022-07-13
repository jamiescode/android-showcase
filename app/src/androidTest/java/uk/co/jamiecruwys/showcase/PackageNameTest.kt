package uk.co.jamiecruwys.showcase

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class PackageNameTest {
    @Test
    fun assertPackageName() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedBasePackageName = "uk.co.jamiecruwys.showcase"
        assertTrue(appContext.packageName.startsWith(expectedBasePackageName))
    }
}
