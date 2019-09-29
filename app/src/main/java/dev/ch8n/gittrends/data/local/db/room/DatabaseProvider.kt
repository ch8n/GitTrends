package dev.ch8n.gittrends.data.local.db.room

import dev.ch8n.gittrends.data.local.db.room.dao.ProfileDao
import dev.ch8n.gittrends.data.local.db.room.dao.ProjectDao

interface DatabaseProvider {

    val projectDao:ProjectDao

    val profileDao:ProfileDao

}