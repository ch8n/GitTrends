package dev.ch8n.gittrends.di.modules

import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dev.ch8n.gittrends.GitTrendApp
import dev.ch8n.gittrends.data.local.db.TrendingItemDB
import dev.ch8n.gittrends.data.model.local.list.TrendingItem
import dev.ch8n.gittrends.data.remote.config.ApiManager
import dev.ch8n.gittrends.data.remote.config.BaseUrl
import dev.ch8n.gittrends.data.remote.config.NETWORK_TIMEOUT
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
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

}