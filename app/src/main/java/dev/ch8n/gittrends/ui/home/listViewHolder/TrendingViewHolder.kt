package dev.ch8n.gittrends.ui.home.listViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.ch8n.gittrends.data.model.local.list.TrendingItem
import kotlinx.android.synthetic.main.item_list_trending.view.*


class TrendingViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {


    fun onBind(item: TrendingItem) = with(view) {

        text_profile_name.text = item.gitProfileName
        chip_profile_url.text = item.username

    }

}
