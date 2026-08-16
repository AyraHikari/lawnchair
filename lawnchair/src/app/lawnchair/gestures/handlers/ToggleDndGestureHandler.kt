package app.lawnchair.gestures.handlers

import android.content.Context
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import app.lawnchair.LawnchairLauncher
import com.android.launcher3.R

class ToggleDndGestureHandler(context: Context) : GestureHandler(context) {

    override suspend fun onTrigger(launcher: LawnchairLauncher) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as
            android.app.NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!notificationManager.isNotificationPolicyAccessGranted) {
                Toast.makeText(context, R.string.gesture_handler_dnd_access_required, Toast.LENGTH_LONG).show()
                val intent = android.content.Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
                intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
                return
            }

            val currentInterruptionFilter = notificationManager.currentInterruptionFilter
            val newFilter = if (currentInterruptionFilter == android.app.NotificationManager.INTERRUPTION_FILTER_PRIORITY) {
                android.app.NotificationManager.INTERRUPTION_FILTER_ALL
            } else {
                android.app.NotificationManager.INTERRUPTION_FILTER_PRIORITY
            }

            notificationManager.setInterruptionFilter(newFilter)

            val isNowEnabled = newFilter != android.app.NotificationManager.INTERRUPTION_FILTER_ALL
            val msg = if (isNowEnabled) {
                R.string.gesture_handler_dnd_enabled
            } else {
                R.string.gesture_handler_dnd_disabled
            }
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, R.string.gesture_handler_dnd_not_supported, Toast.LENGTH_SHORT).show()
        }
    }
}
