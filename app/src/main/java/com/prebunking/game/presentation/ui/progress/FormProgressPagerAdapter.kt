package com.prebunking.game.presentation.ui.progress

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.domain.entity.PostTypeEntity
import com.prebunking.game.presentation.ui.progress.post.FacebookFragment
import com.prebunking.game.presentation.ui.progress.post.TwitterFragment

class FormProgressPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val posts: List<PostEntity>,
    private val answerCallback: (isCorrect: Boolean, post: PostEntity) -> Unit
) : FragmentStateAdapter(
    fragmentManager,
    lifecycle
) {

    override fun getItemCount(): Int = posts.size

    override fun createFragment(position: Int): Fragment {
        val post = posts[position]
        val answerCallback: (isCorrect: Boolean) -> Unit = { isCorrect ->
            answerCallback(isCorrect, posts[position])
        }
        return if (post.typeEntity == PostTypeEntity.FACEBOOK) {
            FacebookFragment(post, answerCallback)
        } else {
            TwitterFragment(post, answerCallback)
        }
    }
}