package com.prebunking.game.presentation.ui.progress.post

import android.view.View
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentTwitterBinding
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.presentation.model.CharacterUI
import com.prebunking.game.presentation.ui.base.BaseFragment

class TwitterFragment(
    private val post: PostEntity,
    private val answerCallback: (isCorrect: Boolean) -> Unit,
) : BaseFragment<FragmentTwitterBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_twitter

    override fun bindLayoutBindings(binding: FragmentTwitterBinding) {
        binding.apply {
            this.post = this@TwitterFragment.post
            fragmentTwitterLayoutQuestion.layoutQuestionButtonTrue.setOnClickListener {
                answerCallback(this@TwitterFragment.post.isTrue)
            }
            fragmentTwitterLayoutQuestion.layoutQuestionButtonFalse.setOnClickListener {
                answerCallback(!this@TwitterFragment.post.isTrue)
            }
        }
    }

    override fun setUpTransitions(view: View) {}
}