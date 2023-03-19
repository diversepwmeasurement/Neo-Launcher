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

package com.saggitt.omega.compose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.saggitt.omega.compose.pages.preferences.mainPrefsGraph
import soup.compose.material.motion.materialSharedAxisX

object Routes {
    const val PREFS_MAIN = "prefs_main"
    const val PREFS_PROFILE = "prefs_profile"
    const val PREFS_DESKTOP = "prefs_desktop"
    const val PREFS_DOCK = "prefs_dock"
    const val PREFS_DRAWER = "prefs_drawer"
    const val PREFS_WIDGETS = "prefs_widgets"
    const val PREFS_SEARCH = "prefs_search"
    const val PREFS_GESTURES = "prefs_gestures"
    const val PREFS_BACKUPS = "prefs_backups"
    const val PREFS_DM = "prefs_desktop_mode"
    const val PREFS_DEV = "prefs_developer"

    const val ABOUT = "about"
    const val TRANSLATORS = "translators"
    const val LICENSE = "license"
    const val CHANGELOG = "changelog"
    const val EDIT_ICON = "edit_icon"
    const val ICON_PICKER = "icon_picker"
    const val GESTURE_SELECTOR = "gesture_selector"
    const val HIDDEN_APPS = "hidden_apps"
    const val PROTECTED_APPS = "protected_apps"
    const val PROTECTED_APPS_VIEW = "protected_apps_view"
    const val CATEGORIZE_APPS = "categorize_apps"
    const val EDIT_DASH = "edit_dash"
    const val ICON_SHAPE = "icon_shape"
    const val COLOR_ACCENT = "color_accent"
    const val COLOR_BG_DESKTOP_FOLDER = "color_bg_desktop_folder"
    const val COLOR_STROKE_FOLDER = "color_stroke_folder"
    const val COLOR_BG_DOCK = "color_bg_dock"
    const val COLOR_BG_DRAWER = "color_bg_drawer"
    const val COLOR_DOTS_NOTIFICATION = "color_dots_notification"
}

val LocalNavController = staticCompositionLocalOf<NavController> {
    error("CompositionLocal LocalNavController not present")
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PrefsComposeView(navController: NavHostController) {
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    val motionSpec = materialSharedAxisX()
    val density = LocalDensity.current
    CompositionLocalProvider(
        LocalNavController provides navController
    ) {
        AnimatedNavHost(
            navController = navController,
            startDestination = "/",
            enterTransition = { motionSpec.enter.transition(!isRtl, density) },
            exitTransition = { motionSpec.exit.transition(!isRtl, density) },
            popEnterTransition = { motionSpec.enter.transition(isRtl, density) },
            popExitTransition = { motionSpec.exit.transition(isRtl, density) },
        ) {
            mainPrefsGraph(route = "/")
        }
    }
}

@Composable
fun BlankScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
    ) {
    }
}