package com.prebunking.game.presentation.ui.characters.details

import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentCharacterDetailsBinding
import com.prebunking.game.presentation.ui.base.BaseFragment

class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_character_details

    override fun bindLayoutBindings(binding: FragmentCharacterDetailsBinding) {
        binding.fragmentCharacterDetailsLayoutButtonContinue.root.setOnClickListener {
            navigateToConfirmation()
        }
    }

    private fun navigateToConfirmation() {
        navController.navigate(CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToCharacterConfirmationFragment())
    }
}