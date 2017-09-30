package com.zhoushibo.moonlight.util

import android.support.design.widget.Snackbar
import android.view.View

/**
 * @author shibo
 * @description
 * @date 2017/9/26
 */
object SnackbarUtils {
    fun showSnackbar(v: View?, snackbarText: String?) {
        if (v == null || snackbarText == null) {
            return
        }
        Snackbar.make(v, snackbarText, Snackbar.LENGTH_LONG).show()
    }
}
