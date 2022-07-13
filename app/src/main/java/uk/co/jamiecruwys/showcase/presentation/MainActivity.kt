package uk.co.jamiecruwys.showcase.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.showcase.R

@AndroidEntryPoint
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.licenses -> showOpenSourceLicenses()
        }
        return true
    }

    private fun showOpenSourceLicenses() {
        val intent = Intent(this, OssLicensesMenuActivity::class.java)
        startActivity(intent)
    }
}
