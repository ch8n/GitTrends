package dev.ch8n.gittrends.ui.home.listViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.ch8n.gittrends.data.model.local.list.TrendingItem
import dev.ch8n.gittrends.utils.loadAvatar
import dev.ch8n.gittrends.utils.toToast
import kotlinx.android.synthetic.main.item_list_trending.view.*


class TrendingViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(item: TrendingItem) = with(view) {
        text_profile_name.text = item.gitProfileName
        chip_profile_url.text = item.username
        image_profile_avatar.loadAvatar(item.avatar)
        chip_profile_url.setOnClickListener {
            item.gitProfileUrl.toToast(context)
        }

        chip_project_url.setOnClickListener {
            item.projectUrl.toToast(context)
        }
        text_project_desc.text = item.projectDesc
        text_project_name.text = item.projectName
    }

}
