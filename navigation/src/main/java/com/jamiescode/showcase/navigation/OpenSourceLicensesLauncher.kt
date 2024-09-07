package com.jamiescode.showcase.navigation

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

fun Context.launchOpenSourceLicenses() {
    val intent = Intent(this, OssLicensesMenuActivity::class.java)
    ContextCompat.startActivity(this, intent, null)
}
