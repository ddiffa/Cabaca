package com.hellodiffa.cabaca.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.logDebbug(message: String) {
    Log.e(this.javaClass.simpleName, message)
}
