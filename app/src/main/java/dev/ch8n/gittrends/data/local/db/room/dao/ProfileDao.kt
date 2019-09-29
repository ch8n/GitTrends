package dev.ch8n.gittrends.data.local.db.room.dao

import androidx.room.*
import dev.ch8n.gittrends.data.model.db.COLOUMN_GIT_USERNAME
import dev.ch8n.gittrends.data.model.db.COLOUMN_USERNAME
import dev.ch8n.gittrends.data.model.db.GitUser
import dev.ch8n.gittrends.data.model.db.TABLE_NAME_USER


@Dao
interface ProfileDao {

    //######## Add/Update ##########

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProfile(profile: GitUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProfiles(profiles: List<GitUser>)

    //######## Select ##########

    @Query("SELECT * FROM $TABLE_NAME_USER")
    suspend fun getProfiles(): List<GitUser>

    @Query("SELECT * FROM $TABLE_NAME_USER WHERE $COLOUMN_USERNAME=:userName")
    suspend fun getProfile(userName: String): GitUser

    @Query("SELECT * FROM $TABLE_NAME_USER WHERE $COLOUMN_GIT_USERNAME=:gitProfileName")
    suspend fun getGitProfile(gitProfileName: String): GitUser


    //######## Delete ##########

    @Delete
    suspend fun clearProfiles()

    @Query("SELECT * FROM $TABLE_NAME_USER WHERE $COLOUMN_USERNAME=:userName")
    suspend fun deleteProfile(userName: String)

    @Query("SELECT * FROM $TABLE_NAME_USER WHERE $COLOUMN_GIT_USERNAME=:gitProfileName")
    suspend fun deleteGitProfile(gitProfileName: String)



}