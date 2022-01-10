package com.prebunking.game.presentation.ui.progress.post

import android.view.View
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentWhatsappBinding
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.presentation.model.CharacterUI
import com.prebunking.game.presentation.ui.base.BaseFragment

class WhatsappFragment(
    private val post: PostEntity,
    private val answerCallback: (isCorrect: Boolean) -> Unit,
) : BaseFragment<FragmentWhatsappBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_whatsapp

    override fun bindLayoutBindings(binding: FragmentWhatsappBinding) {
        binding.apply {
            this.post = this@WhatsappFragment.post
            fragmentWhatsappLayoutQuestion.layoutQuestionButtonTrue.setOnClickListener {
                answerCallback(this@WhatsappFragment.post.isTrue)
            }
            fragmentWhatsappLayoutQuestion.layoutQuestionButtonFalse.setOnClickListener {
                answerCallback(!this@WhatsappFragment.post.isTrue)
            }
        }
    }

    override fun setUpTransitions(view: View) {}
}