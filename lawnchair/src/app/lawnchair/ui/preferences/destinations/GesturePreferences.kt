package app.lawnchair.ui.preferences.destinations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import app.lawnchair.preferences.getAdapter
import app.lawnchair.preferences2.preferenceManager2
import app.lawnchair.ui.preferences.LocalIsExpandedScreen
import app.lawnchair.ui.preferences.components.GestureHandlerPreference
import app.lawnchair.ui.preferences.components.controls.SwitchPreference
import app.lawnchair.ui.preferences.components.layout.PreferenceGroup
import app.lawnchair.ui.preferences.components.layout.PreferenceLayout
import com.android.launcher3.R

@Composable
fun GesturePreferences(
    modifier: Modifier = Modifier,
) {
    val prefs = preferenceManager2()
    PreferenceLayout(
        label = stringResource(id = R.string.gestures_label),
        backArrowVisible = !LocalIsExpandedScreen.current,
        modifier = modifier,
    ) {
        PreferenceGroup {
            SwitchPreference(
                adapter = prefs.numpadToDialer.getAdapter(),
                label = stringResource(id = R.string.numpad_to_dialer_label),
                description = stringResource(id = R.string.numpad_to_dialer_description),
            )
            GestureHandlerPreference(
                adapter = prefs.doubleTapGestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_double_tap),
            )
            GestureHandlerPreference(
                adapter = prefs.swipeUpGestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_swipe_up),
            )
            GestureHandlerPreference(
                adapter = prefs.swipeDownGestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_swipe_down),
            )
            GestureHandlerPreference(
                adapter = prefs.homePressGestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_home_tap),
            )
            GestureHandlerPreference(
                adapter = prefs.backPressGestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_back_tap),
            )
        }
        PreferenceGroup(heading = stringResource(id = R.string.gestures_numpad_long_press_label)) {
            GestureHandlerPreference(
                adapter = prefs.numpadKey0GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_0),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKey1GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_1),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKey2GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_2),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKey3GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_3),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKey4GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_4),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKey5GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_5),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKey6GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_6),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKey7GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_7),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKey8GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_8),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKey9GestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_9),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKeyStarGestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_star),
            )
            GestureHandlerPreference(
                adapter = prefs.numpadKeyPoundGestureHandler.getAdapter(),
                label = stringResource(id = R.string.gesture_numpad_key_pound),
            )
        }
    }
}
