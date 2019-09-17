package dev.ch8n.gittrends.data.model.local.list

data class TrendingItem(
    val avatar: String,
    val gitProfileName: String,
    val gitProfileUrl: String,
    val username: String,
    val projectDesc: String,
    val projectName: String,
    val projectUrl: String
)