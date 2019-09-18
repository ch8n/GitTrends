package dev.ch8n.gittrends.data.remote.sources

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth
import dev.ch8n.gittrends.MainCoroutineRule
import dev.ch8n.gittrends.di.modules.NetworkBinder
import dev.ch8n.gittrends.utils.Utils
import io.mockk.coEvery
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@MediumTest
class GithubSourceTest {


    /**
     * todo:
     * test Source if getting real response
     */

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    lateinit var source: GithubSource

    @Before
    fun setup() {

        val networkBinder = NetworkBinder()
        val okClient = networkBinder.provideOkHttpClient()
        val retrofit = networkBinder.provideRetrofitClient(okClient)
        val apiManager = networkBinder.provideApiManager(retrofit)
        source = GithubSource(apiManager)

    }

    @Test
    fun `check if real api is responding`() = runBlocking {
        val result = source.getTrendingRepos("java")
        Truth.assertThat(result.size).isNotEqualTo(0)
    }


    @Test
    fun `mock real api is responding`() = runBlocking {
        val networkBinder = NetworkBinder()
        val okClient = networkBinder.provideOkHttpClient()
        val retrofit = networkBinder.provideRetrofitClient(okClient)
        val spyApiManager = spyk(networkBinder.provideApiManager(retrofit))
        source = GithubSource(spyApiManager)
        coEvery { spyApiManager.githubService.getTrendingRepos() } returns listOf(Utils.trendingItem)
        val result = source.getTrendingRepos("java")
        Truth.assertThat(result.size).isEqualTo(1)
    }


}