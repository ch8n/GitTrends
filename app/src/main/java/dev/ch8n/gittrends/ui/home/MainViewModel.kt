package dev.ch8n.gittrends.ui.home

import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import dev.ch8n.gittrends.data.model.local.list.TrendingItem
import dev.ch8n.gittrends.data.remote.repos.GithubRepo
import dev.ch8n.gittrends.utils.Result
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val githubRepo: GithubRepo) : ViewModel(),
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    fun getTrendingProjects(language: String): LiveEvent<Result<List<TrendingItem>, Exception>> {
        val result = LiveEvent<Result<List<TrendingItem>, Exception>>()
        this.launch {
            Result.build { githubRepo.getTrendingProjects(language) }
                .let {
                    result.postValue(it)
                }
        }
        return result
    }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

}


