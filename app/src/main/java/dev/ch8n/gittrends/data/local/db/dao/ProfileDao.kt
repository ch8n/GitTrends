package dev.ch8n.gittrends.data.local.db.dao

import androidx.room.*
import dev.ch8n.gittrends.data.model.db.*


@Dao
interface ProfileDao {

    //######## Add/Update ##########

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProfile(profile: GitUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProfiles(profiles: List<GitUser>)

    //######## Select ##########

    @Query("SELECT * FROM GitUser")
    suspend fun getProfiles(): List<GitUser>

    @Query("SELECT * FROM GitUser WHERE username=:userName")
    suspend fun getProfile(userName: String): GitUser

    @Query("SELECT * FROM GitUser WHERE gitProfileName =:gitProfileName")
    suspend fun getGitProfile(gitProfileName: String): GitUser


    //######## Delete ##########

    @Delete
    suspend fun clearProfiles()

    @Query("SELECT * FROM GitUser WHERE username=:userName")
    suspend fun deleteProfile(userName: String)

    @Query("SELECT * FROM GitUser WHERE gitProfileName=:gitProfileName")
    suspend fun deleteGitProfile(gitProfileName: String)



}