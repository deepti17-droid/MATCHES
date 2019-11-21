package com.deepti.matches.utils

import android.app.Activity
import android.app.AlertDialog
import com.deepti.matches.R

object Alerts {

    fun alert(activity: Activity, msg : String){
        val dialogBuilder = AlertDialog.Builder((activity))
        dialogBuilder.setIcon(activity.getDrawable(R.drawable.logo))
        dialogBuilder.setMessage(msg)
            .setCancelable(false)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }
        val alert = dialogBuilder.create()
        alert.setTitle("Alert")
        alert.show()
    }
}