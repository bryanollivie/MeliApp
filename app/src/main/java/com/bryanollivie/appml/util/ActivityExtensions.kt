package com.bryanollivie.appml.util


import android.app.Activity
import android.content.res.Configuration
import com.bryanollivie.appml.R

fun Activity.applyThemeMode() {
    when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
        Configuration.UI_MODE_NIGHT_YES -> setTheme(R.style.AppTheme_Light)
        Configuration.UI_MODE_NIGHT_NO -> setTheme(R.style.AppTheme_Light)
    }
}
