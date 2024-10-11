package com.jamiescode.showcase.navigation

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

fun Context.launchCustomTabs(url: String) {
    val intent = CustomTabsIntent.Builder().build()
    intent.launchUrl(this, Uri.parse(url))
}
