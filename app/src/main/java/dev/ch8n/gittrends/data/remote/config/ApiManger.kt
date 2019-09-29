package dev.ch8n.gittrends.data.remote.config

import dev.ch8n.gittrends.data.remote.sources.GithubService
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

class ApiManager @Inject constructor(private val retrofit: Retrofit) {

    private fun <T> createApi(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

    var githubService: GithubService = createApi(GithubService::class.java)
        private set
}


