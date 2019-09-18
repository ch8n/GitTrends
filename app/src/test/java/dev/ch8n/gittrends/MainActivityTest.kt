package dev.ch8n.gittrends

import android.os.Looper
import android.os.Looper.getMainLooper
import androidx.core.view.isVisible
import androidx.core.view.size
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth
import dev.ch8n.gittrends.ui.home.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.LooperMode

@RunWith(AndroidJUnit4::class)
@MediumTest
class MainActivityTest {

    /**
     * todo:
     * 1. Displaying a recycle view
     * 2. recycle item will be a card view
     * 3. Card view will have a avatar of user
     *      3.1. Clicking on avatar show a bottom sheet
     *      3.2. Bottom sheet has user details and view more button
     *      3.3. view more button opens custom chrome tab with user url
     *      3.4. not all device have custom chrome tab there will use a library with fallback to webview
     * 4. Card view will have project name and desc
     * 5. Click on card view will open the project in custom chrome tab with user url
     *      5.1 not all device have custom chrome tab there will use a library with fallback to webview
     */

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun cleanup() {
        shadowOf(getMainLooper()).idle()
    }

    @Test
    fun `is Activity opening without crash`() {
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { view ->
            Truth.assertThat(view.hasWindowFocus()).isTrue()
        }
    }

    // 1. Displaying a recycle view
    @Test
    fun `is recycle view visible on activity`() {
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { view ->
            Espresso.onView(ViewMatchers.withId(R.id.list_github_trending))
                .check { recycleView, noViewFoundException ->
                    Truth.assertThat(recycleView.isVisible).isTrue()
                }
        }
    }

    // 2. recycle item will be a card view
    @Test
    fun `recycle item has a card view`() {
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onActivity { view ->

            Truth.assertThat(false).isTrue()
        }
    }




}