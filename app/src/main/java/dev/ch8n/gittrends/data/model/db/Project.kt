package dev.ch8n.gittrends.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


const val TABLE_NAME_PROJECT = "projects"
const val COLOUMN_GIT_USERNAME = "git_user_name"
const val COLOUMN_PROJECT_NAME = "project_name"
const val COLOUMN_PROJECT_URL = "project_url"
const val COLOUMN_PROJECT_DESC = "project_desc"

@Entity(tableName = TABLE_NAME_PROJECT)
data class Project(
    @PrimaryKey
    @ColumnInfo(name = COLOUMN_GIT_USERNAME)
    val gitUserName: String,

    @ColumnInfo(name = COLOUMN_PROJECT_DESC)
    val projectDesc: String,

    @ColumnInfo(name = COLOUMN_PROJECT_NAME)
    val projectName: String,

    @ColumnInfo(name = COLOUMN_PROJECT_URL)
    val projectUrl: String
)