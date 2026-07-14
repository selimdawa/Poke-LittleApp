package com.littleapp.poke.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.preference.PreferenceManager
import com.littleapp.poke.R

inline fun <reified T : Activity> Context.launchActivity(
    finishCaller: Boolean = false,
    noinline intentModifier: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)
    intent.intentModifier()
    startActivity(intent)
    if (finishCaller && this is Activity) {
        finish()
    }
}

fun Context.applyAppTheme() {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
    if (sharedPreferences.getString("color_option", "BASIC") == "BASIC") {
        setTheme(R.style.Base_Theme_MainApp)
    }
}
