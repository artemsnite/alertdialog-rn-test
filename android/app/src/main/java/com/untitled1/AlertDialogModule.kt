package com.untitled1

import android.app.AlertDialog
import android.content.DialogInterface
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback

class AlertDialogModule(val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "AlertDialogModule"
    }

    @ReactMethod
        fun showAlert(message: String, onOkPressed: Callback) {
            // Ensure we are using the current activity to prevent the error
            val activity = currentActivity ?: return

            AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton("OK") { dialog, id ->
                    onOkPressed.invoke()
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
}