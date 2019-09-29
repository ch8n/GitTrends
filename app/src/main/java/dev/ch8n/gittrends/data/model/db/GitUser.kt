package dev.ch8n.gittrends.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


const val TABLE_NAME_USER = "gitusers"
const val COLOUMN_AVATAR = "avatar"
const val COLOUMN_GIT_PROFILE_NAME = "git_profile_name"
const val COLOUMN_GIT_PROFILE_URL = "git_profile_url"
const val COLOUMN_USERNAME = "username"

@Entity(tableName = TABLE_NAME_USER)
data class GitUser(

    @PrimaryKey
    @ColumnInfo(name = COLOUMN_USERNAME)
    val username: String,

    @ColumnInfo(name = COLOUMN_AVATAR)
    val avatar: String,

    @ColumnInfo(name = COLOUMN_GIT_PROFILE_NAME)
    val gitProfileName: String,

    @ColumnInfo(name = COLOUMN_GIT_PROFILE_URL)
    val gitProfileUrl: String

)