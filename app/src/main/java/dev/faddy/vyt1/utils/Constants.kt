package dev.faddy.vyt1.utils

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import dev.faddy.vyt1.R

object Constants {
    val BASE_URL = "http://a.random.url"
    val DB_NAME = "com_faddy_exopt1_DB"

    val <T> T.exhaustive: T
        get() = this

    val PREF_NAME = "com.kolpolok.exopt1"

    const val LOGOUT_HANDLER_INTERVAL = (6 * 1000).toLong()  // 5 Seconds
}

fun Context.toast(msg: String?, time: Int = Toast.LENGTH_SHORT) {
    if (!msg.isNullOrEmpty()) {
        val toast = Toast.makeText(this, msg, time)
        val view: View? = toast.view
        view?.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.black))
        val textView: TextView? = view?.findViewById(android.R.id.message)
        textView?.setTextColor(ContextCompat.getColor(this, R.color.white))
        toast.show()
    }
}

fun getDeviceMetrics(context: Context): DisplayMetrics? {
    val metrics = DisplayMetrics()
    val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display: Display = wm.defaultDisplay
    display.getMetrics(metrics)
    return metrics
}

sealed class ViewState {
    object NONE : ViewState()
    data class ShowMessage(val message: String?, val type: Int = 0) : ViewState()
    data class KeyboardState(val isShow: Boolean = false) : ViewState()
    data class ProgressState(val isShow: Boolean = false, val type: Int = 0) : ViewState()
    data class NextState(val type: Int = 0) : ViewState()
    data class EmptyViewState(val type: Int = 0) : ViewState()
}


fun Activity.isTalkbackIsEnabled() =
    (getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager?)?.isTouchExplorationEnabled
        ?: false