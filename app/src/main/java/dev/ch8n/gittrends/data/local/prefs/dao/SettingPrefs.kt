package dev.ch8n.gittrends.data.local.prefs.dao

import android.content.Context
import dev.ch8n.gittrends.data.local.prefs.PreferenceProvider
import dev.ch8n.gittrends.data.local.prefs.config.PrefsConfig
import dev.ch8n.gittrends.utils.get
import dev.ch8n.gittrends.utils.put


const val APP_PREF_FILE_NAME = "dev.ch8n.gittrends.app_prefs"
const val KEY_GITHUB_LOGINED = "$APP_PREF_FILE_NAME.is_github_login"
const val KEY_LAST_SYNC = "$APP_PREF_FILE_NAME.last_sync"

class SettingPrefs(context: Context, fileName: String = APP_PREF_FILE_NAME) :
    PrefsConfig(context, fileName),
    PreferenceProvider.Settings {

    override var isGithubLogin: Boolean
        get() = prefs.get(KEY_GITHUB_LOGINED, false)
        set(value) = prefs.put(KEY_GITHUB_LOGINED, value)

    override var lastSync: Long
        get() = prefs.get(KEY_LAST_SYNC, 0)
        set(value) = prefs.put(KEY_LAST_SYNC, value)
}