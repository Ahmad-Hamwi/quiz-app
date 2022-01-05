package com.prebunking.game.presentation.ui.finish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentFinishBinding
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.presentation.ui.base.BaseFragment
import com.prebunking.game.presentation.ui.characters.details.CharacterDetailsFragmentArgs
import com.prebunking.game.presentation.ui.main.MainViewModel

class FinishFragment : BaseFragment<FragmentFinishBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_finish

    private val mainViewModel: MainViewModel by activityViewModels()
    private val args: CharacterDetailsFragmentArgs by navArgs()

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
        mainViewModel.characters.observe(viewLifecycleOwner) { characters ->
            binding.character = characters.first { it.id == args.characterId }
        }
        mainViewModel.screens.observe(viewLifecycleOwner) { screens ->
            binding.screen = screens.first { it.id == ScreenEntity.FINISH_SCREEN }
        }
    }

    override fun bindLayoutBindings(binding: FragmentFinishBinding) {
        binding.fragmentFinishLayoutButtonContinue.root.setOnClickListener {
            FinishDialog { retry ->
                if (retry) retry()
                else navigateToThankYou()
            }.show(childFragmentManager, "")
        }
    }

    private fun retry() {
        navController.navigate(FinishFragmentDirections.actionFinishFragmentToWelcomeFragment())
    }

    private fun navigateToThankYou() {
        navController.navigate(FinishFragmentDirections.actionFinishFragmentToThankYouFragment()
        )
    }
}