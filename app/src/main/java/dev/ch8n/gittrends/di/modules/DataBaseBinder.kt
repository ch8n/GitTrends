package dev.ch8n.gittrends.di.modules

import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dev.ch8n.gittrends.GitTrendApp
import dev.ch8n.gittrends.data.local.db.TrendingItemDB
import dev.ch8n.gittrends.data.local.prefs.AppPrefs
import dev.ch8n.gittrends.data.local.prefs.dao.SettingPrefs
import dev.ch8n.gittrends.data.local.prefs.PreferenceProvider
import javax.inject.Singleton

@Module
class DataBaseBinder {

    @Provides
    fun provideRoomClient(app: GitTrendApp) =
        Room.databaseBuilder(app.applicationContext, TrendingItemDB::class.java, "GitTrendDB")
            .fallbackToDestructiveMigration()

    @Provides
    @Singleton
    fun provideGitTrendDB(roomClient: RoomDatabase.Builder<TrendingItemDB>): TrendingItemDB =
        roomClient.build()


    @Provides
    @Singleton
    fun provideApplicationPrefs(app:GitTrendApp):PreferenceProvider = AppPrefs(app.applicationContext)


}