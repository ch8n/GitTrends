package dev.ch8n.gittrends.utils

import dev.ch8n.gittrends.data.local.db.sources.entities.CachedTrendingItem
import dev.ch8n.gittrends.data.model.local.list.TrendingItem
import dev.ch8n.gittrends.data.model.remote.GitRepo
import dev.ch8n.gittrends.data.model.remote.TrendingResponse

object Utils {

    val trendingItem = TrendingResponse("testAvatar","test", GitRepo("testDesc","testName","TestUrl"),"TestURL2","testUserName")

    fun getSampleTrendingData() = listOf(
        TrendingItem(
            "http://i.imgur.com/DvpvklR.png",
            "pokemon1",
            "Demo profile url",
            "Demo User Name",
            "Demo project desc http://i.imgur.com/DvpvklR.png bla bla bla",
            "demo project name",
            "Demo project url"
        ),
        TrendingItem(
            "http://i.imgur.com/DvpvklR.png",
            "pokemon2",
            "Demo profile url",
            "Demo User Name",
            "Demo project desc http://i.imgur.com/DvpvklR.png bla bla bla",
            "demo project name",
            "Demo project url"
        ),
        TrendingItem(
            "http://i.imgur.com/DvpvklR.png",
            "pokemon3",
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
                "blablabla",
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
                "blablabla",
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
                "blablabla",
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