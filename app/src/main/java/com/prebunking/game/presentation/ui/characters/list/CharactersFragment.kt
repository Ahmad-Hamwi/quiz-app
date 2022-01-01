package com.prebunking.game.presentation.ui.characters.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentCharactersBinding
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.presentation.model.CharacterUI
import com.prebunking.game.presentation.ui.base.BaseFragment
import com.prebunking.game.presentation.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_characters

    private val mainViewModel: MainViewModel by activityViewModels()

    private fun navigateToCharacterDetails(characterId: Int) {
        navController.navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                characterId
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        initList()
        observeViewModel()

        return view
    }

    private fun initList() {
        val flexboxLayoutManager = FlexboxLayoutManager(requireContext()).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }

        val charactersAdapter: CharactersAdapter =
            CharactersAdapter(requireContext()) { item: CharacterUI, position: Int ->
                navigateToCharacterDetails(item.id!!)
            }

        binding.apply {
            fragmentCharactersList.apply {
                adapter = charactersAdapter
                layoutManager = flexboxLayoutManager
            }
        }
    }

    private fun observeViewModel() {
        mainViewModel.screens.observe(viewLifecycleOwner) { list ->
            list.first { it.id == ScreenEntity.CHARACTER_LIST_SCREEN }
                .apply { binding.charactersListScreen = this }
        }

        binding.characters = mainViewModel.characters
    }
}