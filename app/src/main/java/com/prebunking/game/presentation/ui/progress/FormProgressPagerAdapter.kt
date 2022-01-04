package com.prebunking.game.presentation.ui.progress

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.presentation.ui.progress.post.TwitterFragment

class FormProgressPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val posts: List<PostEntity>
) : FragmentStateAdapter(
    fragmentManager,
    lifecycle
) {

    override fun getItemCount(): Int = posts.size

    override fun createFragment(position: Int): Fragment = TwitterFragment(posts[position])
}