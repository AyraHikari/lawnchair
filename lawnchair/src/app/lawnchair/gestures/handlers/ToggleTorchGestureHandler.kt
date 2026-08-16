package app.lawnchair.gestures.handlers

import android.content.Context
import android.hardware.camera2.CameraManager
import android.widget.Toast
import app.lawnchair.LawnchairLauncher
import com.android.launcher3.R

class ToggleTorchGestureHandler(context: Context) : GestureHandler(context) {

    override suspend fun onTrigger(launcher: LawnchairLauncher) {
        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList.firstOrNull() ?: run {
            Toast.makeText(context, R.string.gesture_handler_torch_no_camera, Toast.LENGTH_SHORT).show()
            return
        }
        val currentMode = cameraManager.getCameraCharacteristics(cameraId)
            .get(android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE)
        if (currentMode != true) {
            Toast.makeText(context, R.string.gesture_handler_torch_no_support, Toast.LENGTH_SHORT).show()
            return
        }
        val isTorchOn = torchState[cameraId] ?: false
        try {
            cameraManager.setTorchMode(cameraId, !isTorchOn)
            torchState[cameraId] = !isTorchOn
            val msg = if (!isTorchOn) {
                R.string.gesture_handler_torch_enabled
            } else {
                R.string.gesture_handler_torch_disabled
            }
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(context, R.string.gesture_handler_torch_error, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private val torchState = mutableMapOf<String, Boolean>()
    }
}
