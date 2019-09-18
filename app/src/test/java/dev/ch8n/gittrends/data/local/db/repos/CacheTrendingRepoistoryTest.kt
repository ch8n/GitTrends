package dev.ch8n.gittrends.data.local.db.repos

import android.os.Looper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth
import dev.ch8n.gittrends.MainCoroutineRule
import dev.ch8n.gittrends.data.local.db.TrendingItemDB
import dev.ch8n.gittrends.data.local.db.sources.dao.TrendingItemsDao
import dev.ch8n.gittrends.di.modules.DataBaseBinder
import dev.ch8n.gittrends.utils.Result
import dev.ch8n.gittrends.utils.Utils
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows
import java.util.concurrent.TimeUnit

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@MediumTest
class CacheTrendingRepoistoryTest {

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: TrendingItemDB
    private lateinit var repo: CacheTrendingRepoistory
    private lateinit var dao: TrendingItemsDao

    @Before
    fun setup() {

        val datbaseBinder = DataBaseBinder()

        database = datbaseBinder.provideGitTrendDB(
            Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                TrendingItemDB::class.java
            ).allowMainThreadQueries()
        )

        dao = database.trendingItemDao()
        repo = CacheTrendingRepoistory(dao)

    }

    @After
    fun cleanUp() {
        database.close()
    }

    @Test
    fun `insert LocalTrending Items to DB`() = runBlocking {

        dao.putTrendingItems(Utils.getSampleCacheTrendingData())
        Shadows.shadowOf(Looper.getMainLooper()).idleFor(2, TimeUnit.SECONDS)
        val result = dao.getTrendingItems()
        Truth.assertThat(result.size).isEqualTo(5)

    }


}