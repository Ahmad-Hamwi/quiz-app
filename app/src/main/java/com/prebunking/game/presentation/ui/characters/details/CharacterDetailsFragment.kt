package com.prebunking.game.presentation.ui.characters.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentCharacterDetailsBinding
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.presentation.ui.base.BaseFragment
import com.prebunking.game.presentation.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_character_details

    override fun bindLayoutBindings(binding: FragmentCharacterDetailsBinding) {
        binding.fragmentCharacterDetailsLayoutButtonContinue.root.setOnClickListener {
            navigateToConfirmation()
        }
    }

    private fun navigateToConfirmation() {
        navController.navigate(
            CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToCharacterConfirmationFragment(
                args.characterId
            )
        )
    }

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

        mainViewModel.screens.observe(viewLifecycleOwner) { screens ->
            screens
                .first { it.id == ScreenEntity.CHARACTER_DETAILS_SCREEN }
                .apply { binding.characterDetailsScreen = this }
        }

        mainViewModel.characters.observe(viewLifecycleOwner) { characters ->
            characters
                .first { it.id == args.characterId }
                .apply { binding.character = this }
        }
    }

}