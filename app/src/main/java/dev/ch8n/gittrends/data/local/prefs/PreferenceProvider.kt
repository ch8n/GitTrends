package dev.ch8n.gittrends.data.local.prefs

interface PreferenceProvider {

    interface Settings{
        var isGithubLogin:Boolean
        var lastSync:Long
    }

    interface User{
        var userName:String
        var primaryEmail:String
        var githubEmail:String
    }

    val settings : PreferenceProvider.Settings
    val user: PreferenceProvider.User

}