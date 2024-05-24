package uk.co.jamiecruwys.navigation

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

class OpenSourceLicensesLauncher {
    fun launch(context: Context) {
        val intent = Intent(context, OssLicensesMenuActivity::class.java)
        ContextCompat.startActivity(context, intent, null)
    }
}
