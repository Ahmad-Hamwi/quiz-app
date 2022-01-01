package com.prebunking.game.presentation.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.navGraphViewModels
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentWelcomeBinding
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.presentation.ui.base.BaseFragment
import com.prebunking.game.presentation.ui.main.MainViewModel
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

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        observeViewModel()

        return view
    }

    private fun observeViewModel() {
        mainViewModel.screens.observe(viewLifecycleOwner) { list ->
            list.first { it.id == ScreenEntity.WELCOME_SCREEN }
                .apply { binding.welcomeScreen = this }
        }
    }
}