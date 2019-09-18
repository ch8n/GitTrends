package dev.ch8n.gittrends.ui.home

import android.util.Log
import androidx.lifecycle.Observer
import dev.ch8n.gittrends.R
import dev.ch8n.gittrends.data.model.local.list.TrendingItem
import dev.ch8n.gittrends.ui.base.BaseActivity
import dev.ch8n.gittrends.ui.base.adapters.TrendingListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import dev.ch8n.gittrends.utils.Result

class MainActivity : BaseActivity() {

    override val contentView: Int
        get() = R.layout.activity_main

    @Inject
    lateinit var viewModel: MainViewModel

    lateinit var trendingListAdapter: TrendingListAdapter

    override fun setup() {

        list_github_trending.run {
            adapter = TrendingListAdapter.newInstance()
                .also {
                    trendingListAdapter = it
                }
        }

        viewModel.getTrendingProjects("java")
            .observe(this, Observer { result ->
                when (result) {
                    is Result.Success -> onSuccessTrendingInfo(result)
                    is Result.Error -> onError(result)
                }
            })


    }

    private fun onError(error: Result.Error<Exception>) {
        Log.e("response", error.error.localizedMessage)
    }

    private fun onSuccessTrendingInfo(result: Result.Success<List<TrendingItem>>) =
        trendingListAdapter.submitList(result.value)

}
