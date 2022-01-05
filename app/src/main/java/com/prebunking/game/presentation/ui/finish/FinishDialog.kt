package com.prebunking.game.presentation.ui.finish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.prebunking.game.R
import com.prebunking.game.databinding.DialogFinishBinding
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.presentation.ui.base.BaseDialogFragment
import com.prebunking.game.presentation.ui.main.MainViewModel

class FinishDialog(
    private val onAction: (redo: Boolean) -> Unit
) : BaseDialogFragment<DialogFinishBinding>() {
    override fun getLayoutId(): Int = R.layout.dialog_finish

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL, R.style.dialog_style)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        mainViewModel.screens.observe(viewLifecycleOwner) { screens ->
            binding.screen = screens.first { it.id == ScreenEntity.REDO_SCREEN }
        }

        return view
    }

    override fun bindLayoutBindings(binding: DialogFinishBinding) {
        binding.apply {
            dialogFinishReplay.setOnClickListener {
                onAction(true)
                dismiss()
            }
            dialogFinishQuit.setOnClickListener {
                onAction(false)
                dismiss()
            }
        }
    }
}