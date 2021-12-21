package com.prebunking.game.presentation.ui.characters

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentCharactersBinding
import com.prebunking.game.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_characters

    private val viewModel: ViewModel by viewModels()
}