package dev.ch8n.gittrends.ui.gitPreview

import dev.ch8n.gittrends.R
import dev.ch8n.gittrends.ui.base.BaseActivity
import dev.ch8n.gittrends.utils.setVisibility
import dev.ch8n.gittrends.utils.toToast
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : BaseActivity() {
    override val contentView: Int
        get() = R.layout.activity_preview

    override fun setup() {
        fab_preview_back.setOnClickListener { finish() }
        progress_view.setVisibility(true)
        intent.extras.getString(PREVIEW_URL).toString().toToast(this)
    }

}

const val PREVIEW_URL = "PREVIEW_URL"
