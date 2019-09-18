package dev.ch8n.gittrends.utils

import dev.ch8n.gittrends.data.local.db.sources.entities.CachedTrendingItem
import dev.ch8n.gittrends.data.model.local.list.TrendingItem

object Utils {

    fun getSampleTrendingData() = listOf(
        TrendingItem(
            "http://i.imgur.com/DvpvklR.png",
            "DemoProfileName",
            "Demo profile url",
            "Demo User Name",
            "Demo project desc http://i.imgur.com/DvpvklR.png bla bla bla",
            "demo project name",
            "Demo project url"
        ),
        TrendingItem(
            "http://i.imgur.com/DvpvklR.png",
            "DemoProfileName",
            "Demo profile url",
            "Demo User Name",
            "Demo project desc http://i.imgur.com/DvpvklR.png bla bla bla",
            "demo project name",
            "Demo project url"
        ),
        TrendingItem(
            "http://i.imgur.com/DvpvklR.png",
            "DemoProfileName",
            "Demo profile url",
            "Demo User Name",
            "Demo project desc http://i.imgur.com/DvpvklR.png bla bla bla",
            "demo project name",
            "Demo project url"
        )
    )

    fun getSampleCacheTrendingData(): MutableList<CachedTrendingItem> {
        val mutableList = mutableListOf<CachedTrendingItem>()
        mutableList.add(
            CachedTrendingItem(
                "Pokemon1",
                "Pokemon1",
                "Demo profile url",
                "Demo User Name",
                "Demo project desc http://i.imgur.com/DvpvklR.png bla bla bla",
                "demo project name",
                "Demo project url"
            )
        )

        mutableList.add(
            CachedTrendingItem(
                "Pokemon2",
                "Pokemon2",
                "Demo profile url",
                "Demo User Name",
                "Demo project desc http://i.imgur.com/DvpvklR.png bla bla bla",
                "demo project name",
                "Demo project url"
            )
        )

        mutableList.add(
            CachedTrendingItem(
                "Pokemon3",
                "Pokemon3",
                "Demo profile url",
                "Demo User Name",
                "Demo project desc http://i.imgur.com/DvpvklR.png bla bla bla",
                "demo project name",
                "Demo project url"
            )
        )

        return mutableList
    }


}