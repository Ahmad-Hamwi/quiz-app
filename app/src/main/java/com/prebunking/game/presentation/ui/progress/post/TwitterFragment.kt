package com.prebunking.game.presentation.ui.progress.post

import android.view.View
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentTwitterBinding
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.presentation.ui.base.BaseFragment

class TwitterFragment(
    private val post: PostEntity
) : BaseFragment<FragmentTwitterBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_twitter

    override fun bindLayoutBindings(binding: FragmentTwitterBinding) {
        binding.apply { post = this.post }
    }

    override fun setUpTransitions(view: View) {}
}