package com.prebunking.game.presentation.ui.progress.dialog

import android.os.Bundle
import com.prebunking.game.R
import com.prebunking.game.databinding.DialogWrongAnswerBinding
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.presentation.ui.base.BaseDialogFragment

class WrongAnswerDialog(
    private val post: PostEntity,
    private val screen: ScreenEntity,
    private val continueCallback: () -> Unit
) : BaseDialogFragment<DialogWrongAnswerBinding>() {
    override fun getLayoutId(): Int = R.layout.dialog_wrong_answer

    override fun bindLayoutBindings(binding: DialogWrongAnswerBinding) {
        binding.apply {
            dialogCorrectAnswerContinue.setOnClickListener {
                continueCallback()
                dismiss()
            }

            this.screen = this@WrongAnswerDialog.screen

            this.post = this@WrongAnswerDialog.post
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL, R.style.dialog_style)
    }
}