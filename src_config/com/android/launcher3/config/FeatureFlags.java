/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.launcher3.config;

/**
 * Defines a set of flags used to control various launcher behaviors
 */
public final class FeatureFlags {
    private FeatureFlags() {}

    // Custom flags go below this
    public static boolean LAUNCHER3_DISABLE_ICON_NORMALIZATION = false;
    public static boolean LAUNCHER3_LEGACY_FOLDER_ICON = false;
    public static boolean LAUNCHER3_USE_SYSTEM_DRAG_DRIVER = true;
    public static boolean LAUNCHER3_DISABLE_PINCH_TO_OVERVIEW = false;

    // 是否禁用往上滑动显示所有app的列表界面
    public static boolean LAUNCHER3_ALL_APPS_PULL_UP = false;

    public static boolean LAUNCHER3_NEW_FOLDER_ANIMATION = false;
    // When enabled allows to use any point on the fast scrollbar to start dragging.
    public static boolean LAUNCHER3_DIRECT_SCROLL = true;
    // When enabled while all-apps open, the soft input will be set to adjust resize .
    public static boolean LAUNCHER3_UPDATE_SOFT_INPUT_MODE = false;


    // Feature flag to enable moving the QSB on the 0th screen of the workspace.
    // 设置是否在桌面显示Google搜索框 true=显示
    public static final boolean QSB_ON_FIRST_SCREEN = false;

    // When enabled the all-apps icon is not added to the hotseat.
    // 是否在hotseat条禁止显示全部应用的按钮 true=禁止显示
    public static final boolean NO_ALL_APPS_ICON = true;

    // When enabled fling down gesture on the first workspace triggers search.
    // 是否在第一屏，向下拖动支持打开搜索界面  true=支持
    public static final boolean PULLDOWN_SEARCH = false;

    // When enabled the status bar may show dark icons based on the top of the wallpaper.
    public static final boolean LIGHT_STATUS_BAR = false;

    // When enabled icons are badged with the number of notifications associated with that app.
    public static final boolean BADGE_ICONS = true;

    // When enabled, icons not supporting {@link AdaptiveIconDrawable} will be wrapped in this class.
    public static final boolean LEGACY_ICON_TREATMENT = true;

    // When enabled, adaptive icons would have shadows baked when being stored to icon cache.
    public static final boolean ADAPTIVE_ICON_SHADOW = true;

    // When enabled, app discovery will be enabled if service is implemented
    public static final boolean DISCOVERY_ENABLED = false;

    // ADD 是否显示向上的小箭头
    public static final boolean ALL_APPS_HANDLE = false;


}
