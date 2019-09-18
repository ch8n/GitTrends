package dev.ch8n.gittrends.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.ch8n.gittrends.data.local.db.sources.dao.TrendingItemsDao
import dev.ch8n.gittrends.data.local.db.sources.entities.CachedTrendingItem


@Database(entities = [CachedTrendingItem::class], version = 1, exportSchema = false)
abstract class TrendingItemDB : RoomDatabase() {

    abstract fun trendingItemDao(): TrendingItemsDao

}