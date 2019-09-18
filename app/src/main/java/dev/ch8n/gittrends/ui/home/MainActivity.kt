package dev.ch8n.gittrends.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import dev.ch8n.gittrends.R
import dev.ch8n.gittrends.data.model.local.list.TrendingItem
import dev.ch8n.gittrends.ui.base.BaseActivity
import dev.ch8n.gittrends.ui.base.adapters.AdapaterEvents
import dev.ch8n.gittrends.ui.base.adapters.TrendingListAdapter
import dev.ch8n.gittrends.ui.gitPreview.PREVIEW_URL
import dev.ch8n.gittrends.ui.gitPreview.PreviewActivity
import dev.ch8n.gittrends.ui.home.dialogs.GitProfileBottomSheet
import dev.ch8n.gittrends.utils.Result
import dev.ch8n.gittrends.utils.launchActivity
import dev.ch8n.gittrends.utils.logError
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), GitProfileBottomSheet.GitBottomSheetListener {

    override val contentView: Int
        get() = R.layout.activity_main

    @Inject
    lateinit var viewModel: MainViewModel

    lateinit var trendingListAdapter: TrendingListAdapter
    private var bottomSheet: GitProfileBottomSheet? = null

    override fun setup() {

        list_github_trending.run {
            adapter = TrendingListAdapter.newInstance()
                .also {
                    trendingListAdapter = it
                }
        }

        trendingListAdapter.onEvent().observe(this, Observer { event ->
            when (event) {
                is AdapaterEvents.OnClickLearnMore -> onClickOfTrendingList(event)
            }
        })

        getTrendRepoEvent()

        swipe_refresh.setOnRefreshListener {
            getTrendRepoEvent()
        }
    }

    private fun getTrendRepoEvent() {
        swipe_refresh.isRefreshing = true
        viewModel.getTrendingProjects("java")
            .observe(this, Observer { result ->
                swipe_refresh.isRefreshing = false
                when (result) {
                    is Result.Success -> onSuccessTrendingInfo(result)
                    is Result.Error -> onError(result)
                }
            })
    }

    private fun onClickOfTrendingList(event: AdapaterEvents.OnClickLearnMore) {
        val item = trendingListAdapter.getItemAt(event.position)
        if (bottomSheet?.isVisible == true) {
            bottomSheet?.dismiss()
        }
        bottomSheet = GitProfileBottomSheet.newInstance(item)
        bottomSheet?.show(supportFragmentManager, "btm_profile")
    }

    private fun onError(error: Result.Error<Exception>) {
        error.error.localizedMessage.logError()
    }

    private fun onSuccessTrendingInfo(result: Result.Success<List<TrendingItem>>) =
        trendingListAdapter.submitList(result.value)

    override fun onClickPreviewProject(url: String) {
        if (bottomSheet?.isVisible == true) {
            bottomSheet?.dismiss()
        }
        launchActivity<PreviewActivity>(Bundle().also {
            it.putString(PREVIEW_URL, url)
        })
    }

    override fun onClickPreviewProfile(url: String) = onClickPreviewProject(url)

}
