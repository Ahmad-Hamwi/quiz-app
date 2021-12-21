package com.prebunking.game.presentation.ui.welcome

import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentWelcomeBinding
import com.prebunking.game.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_welcome

    override fun bindLayoutBindings(binding: FragmentWelcomeBinding) {
        binding.apply {
            fragmentWelcomeLayoutButtonContinue.root.setOnClickListener {
                navController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToCharactersFragment())
            }
        }
    }
}