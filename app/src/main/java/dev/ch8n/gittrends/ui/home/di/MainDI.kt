package dev.ch8n.gittrends.ui.home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import dev.ch8n.gittrends.data.local.db.TrendingItemDB
import dev.ch8n.gittrends.data.local.db.repos.CacheTrendingRepo
import dev.ch8n.gittrends.data.local.db.repos.CacheTrendingRepoistory
import dev.ch8n.gittrends.data.remote.repos.GithubRepo
import dev.ch8n.gittrends.data.remote.repos.GithubRepository
import dev.ch8n.gittrends.data.remote.sources.GithubSource
import dev.ch8n.gittrends.ui.home.MainActivity
import dev.ch8n.gittrends.ui.home.MainViewModel
import javax.inject.Inject

@Module
class MainDI {

    @Provides
    fun provideGithubRepo(githubSource: GithubSource): GithubRepo = GithubRepository(githubSource)

    @Provides
    fun provideCachingRepo(trendingItemDB: TrendingItemDB): CacheTrendingRepo =
        CacheTrendingRepoistory(trendingItemDB.trendingItemDao())

    @Provides
    fun provideMainViewModel(
        mainActivity: MainActivity,
        factory: MainViewModelFactory
    ): MainViewModel = ViewModelProviders.of(mainActivity, factory)
        .get(MainViewModel::class.java)

}

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor(
    private val githubRepo: GithubRepo,
    private val cacheRepoistory: CacheTrendingRepo
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(githubRepo,cacheRepoistory) as T
    }
}