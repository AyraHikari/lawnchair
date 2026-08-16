package app.lawnchair.gestures.handlers

import android.content.Context
import android.media.AudioManager
import android.widget.Toast
import app.lawnchair.LawnchairLauncher
import com.android.launcher3.R

class ToggleSilentModeGestureHandler(context: Context) : GestureHandler(context) {

    override suspend fun onTrigger(launcher: LawnchairLauncher) {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

        val currentRingerMode = audioManager.ringerMode
        val newRingerMode = if (currentRingerMode == AudioManager.RINGER_MODE_SILENT) {
            AudioManager.RINGER_MODE_NORMAL
        } else {
            AudioManager.RINGER_MODE_SILENT
        }

        audioManager.ringerMode = newRingerMode

        val isNowSilent = newRingerMode == AudioManager.RINGER_MODE_SILENT
        val msg = if (isNowSilent) {
            R.string.gesture_handler_silent_enabled
        } else {
            R.string.gesture_handler_silent_disabled
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
