package com.example.app.utils

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.example.app.R

object DialogUtils {

    fun createProgress(context: Context): MaterialDialog {
        return MaterialDialog.Builder(context)
            .progress(true, 0)
            .contentColor(context.resources.getColor(R.color.colorPrimary))
            .widgetColor(context.resources.getColor(R.color.colorPrimary))
            .cancelable(false)
            .content("Procurando voos...")
            .progressIndeterminateStyle(true)
            .build()
    }

}