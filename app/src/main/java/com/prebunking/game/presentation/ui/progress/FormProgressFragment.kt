package com.prebunking.game.presentation.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentFormProgressBinding
import com.prebunking.game.presentation.ui.base.BaseFragment
import com.prebunking.game.presentation.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormProgressFragment : BaseFragment<FragmentFormProgressBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_form_progress

    override fun bindLayoutBindings(binding: FragmentFormProgressBinding) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        initPager()

        return view
    }

    private val mainViewModel: MainViewModel by activityViewModels()

    private fun initPager() {
//        binding.fragmentFormProgressPager.adapter =
//            FormProgressPagerAdapter(childFragmentManager, lifecycle)
    }
}