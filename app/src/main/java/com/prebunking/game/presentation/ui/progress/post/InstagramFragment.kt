package com.prebunking.game.presentation.ui.progress.post

import android.view.View
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentInstagramBinding
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.presentation.ui.base.BaseFragment

class InstagramFragment(
    private val post: PostEntity,
    private val answerCallback: (isTrue: Boolean) -> Unit
) : BaseFragment<FragmentInstagramBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_instagram

    override fun bindLayoutBindings(binding: FragmentInstagramBinding) {
        binding.apply {
            this.post = this@InstagramFragment.post
            fragmentInstagramLayoutQuestion.layoutQuestionButtonTrue.setOnClickListener {
                answerCallback(this@InstagramFragment.post.isTrue)
            }
            fragmentInstagramLayoutQuestion.layoutQuestionButtonFalse.setOnClickListener {
                answerCallback(!this@InstagramFragment.post.isTrue)
            }
        }
    }

    override fun setUpTransitions(view: View) {}
}