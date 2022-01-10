package com.prebunking.game.presentation.ui.thankyou

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentThankYouBinding
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.presentation.ui.base.BaseFragment
import com.prebunking.game.presentation.ui.characters.details.CharacterDetailsFragmentArgs
import com.prebunking.game.presentation.ui.finish.FinishFragmentDirections
import com.prebunking.game.presentation.ui.main.MainActivity
import com.prebunking.game.presentation.ui.main.MainViewModel

class ThankYouFragment : BaseFragment<FragmentThankYouBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_thank_you

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
        mainViewModel.screens.observe(viewLifecycleOwner) { screens ->
            binding.screen = screens.first { it.id == ScreenEntity.THANK_YOU_SCREEN }
        }
    }

    override fun bindLayoutBindings(binding: FragmentThankYouBinding) {
        binding.apply {
            fragmentThankYouButton.setOnClickListener {
                retry()
            }
        }
    }

    private fun retry() {
        requireActivity().finish()
        startActivity(Intent(activity, MainActivity::class.java))
    }
}