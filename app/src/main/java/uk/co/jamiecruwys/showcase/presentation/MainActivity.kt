package uk.co.jamiecruwys.showcase.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uk.co.jamiecruwys.showcase.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}