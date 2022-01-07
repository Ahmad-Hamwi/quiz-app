package com.prebunking.game.presentation.ui.progress.post

import android.view.View
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentFacebookBinding
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.presentation.ui.base.BaseFragment

class FacebookFragment(
    private val post: PostEntity,
    private val answerCallback: (isTrue: Boolean) -> Unit
) : BaseFragment<FragmentFacebookBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_facebook

    override fun bindLayoutBindings(binding: FragmentFacebookBinding) {
        binding.apply {
            this.post = this@FacebookFragment.post
            fragmentFacebookLayoutQuestion.layoutQuestionButtonTrue.setOnClickListener {
                answerCallback(this@FacebookFragment.post.isTrue)
            }
            fragmentFacebookLayoutQuestion.layoutQuestionButtonFalse.setOnClickListener {
                answerCallback(!this@FacebookFragment.post.isTrue)
            }
        }
    }

    override fun setUpTransitions(view: View) {}
}