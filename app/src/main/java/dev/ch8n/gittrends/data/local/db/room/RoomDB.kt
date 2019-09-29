package dev.ch8n.gittrends.data.local.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.ch8n.gittrends.data.local.db.room.dao.ProfileDao
import dev.ch8n.gittrends.data.local.db.room.dao.ProjectDao
import dev.ch8n.gittrends.data.local.db.sources.dao.TrendingItemsDao
import dev.ch8n.gittrends.data.local.db.sources.entities.CachedTrendingItem
import dev.ch8n.gittrends.data.model.db.GitUser
import dev.ch8n.gittrends.data.model.db.Project


@Database(
    entities = arrayOf(
        CachedTrendingItem::class,
        GitUser::class,
        Project::class
    ),
    version = 2,
    exportSchema = false
)
abstract class RoomDB : RoomDatabase() {

    abstract fun trendingItemDao(): TrendingItemsDao

    abstract fun projectDao(): ProjectDao
    abstract fun profileDao(): ProfileDao

}

const val ROOM_DB_NAME = "Git_trend_db"