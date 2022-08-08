/*
 * This file is part of Neo Launcher
 * Copyright (c) 2022   Neo Launcher Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.saggitt.omega.gestures.actions

import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.view.View
import com.android.launcher3.R
import com.saggitt.omega.gestures.GestureController
import org.json.JSONObject

class DeviceSettingsAction(context: Context, config: JSONObject?) : GestureAction(context, config) {
    override val displayName = context.getString(R.string.dash_device_settings_summary)
    override val icon = R.drawable.ic_setting
    override val iconResource: Intent.ShortcutIconResource by lazy {
        Intent.ShortcutIconResource.fromContext(context, R.drawable.ic_setting)
    }

    override fun onGestureTrigger(controller: GestureController, view: View?) {
        context.startActivity(Intent(Settings.ACTION_SETTINGS))
    }
}