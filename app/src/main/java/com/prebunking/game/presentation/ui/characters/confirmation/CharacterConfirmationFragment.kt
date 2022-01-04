package com.prebunking.game.presentation.ui.characters.confirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentCharacterConfirmationBinding
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.presentation.ui.base.BaseFragment
import com.prebunking.game.presentation.ui.main.MainViewModel

class CharacterConfirmationFragment : BaseFragment<FragmentCharacterConfirmationBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_character_confirmation

    private val mainViewModel: MainViewModel by activityViewModels()
    private val navArgs: CharacterConfirmationFragmentArgs by navArgs()

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
            list.first { it.id == ScreenEntity.CHARACTER_CONFIRMATION_SCREEN }
                .apply { binding.characterConfirmationScreen = this }
        }

        mainViewModel.characters.observe(viewLifecycleOwner) { characters ->
            characters
                .first { it.id == navArgs.characterId }
                .apply { binding.character = this }
        }

        mainViewModel.sessionCreated.observe(viewLifecycleOwner) { isSessionCreated ->
            if (isSessionCreated) navigateToFormFragment()
        }
    }

    override fun bindLayoutBindings(binding: FragmentCharacterConfirmationBinding) {
        binding.apply {
            fragmentCharacterConfirmationLayoutButtonContinue.root.setOnClickListener {
                mainViewModel.createSession(navArgs.characterId)
            }
        }
    }

    private fun navigateToFormFragment() {
        navController.navigate(
            CharacterConfirmationFragmentDirections
                .actionCharacterConfirmationFragmentToFormProgressFragment(navArgs.characterId)
        )
    }
}