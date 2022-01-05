package com.prebunking.game.presentation.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.prebunking.game.R
import com.prebunking.game.databinding.FragmentFormProgressBinding
import com.prebunking.game.domain.entity.PostEntity
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.presentation.ui.base.BaseFragment
import com.prebunking.game.presentation.ui.main.MainViewModel
import com.prebunking.game.presentation.ui.progress.dialog.CorrectAnswerDialog
import com.prebunking.game.presentation.ui.progress.dialog.WrongAnswerDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormProgressFragment : BaseFragment<FragmentFormProgressBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_form_progress

    override fun bindLayoutBindings(binding: FragmentFormProgressBinding) {
        binding.apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        observeViewModel()
        initPager()

        return view
    }

    private val mainViewModel: MainViewModel by activityViewModels()
    private val navArgs: FormProgressFragmentArgs by navArgs()

    private lateinit var correctScreen: ScreenEntity
    private lateinit var wrongScreen: ScreenEntity

    private fun observeViewModel() {
        mainViewModel.screens.observe(viewLifecycleOwner) { screens ->
            correctScreen = screens.first { it.id == ScreenEntity.CORRECT_ANSWER_SCREEN }
            wrongScreen = screens.first { it.id == ScreenEntity.WRONG_ANSWER_SCREEN }
        }
    }

    private lateinit var pagerAdapter: FormProgressPagerAdapter

    private fun initPager() {
        binding.fragmentFormProgressPager.isUserInputEnabled = false

        FormProgressPagerAdapter(
            childFragmentManager,
            lifecycle,
            mainViewModel.sessionCreated.value!!.posts,
        ) { isCorrect, post ->
            mainViewModel.postToSession(post.id, isCorrect)
            showDialogs(isCorrect, post)
        }.apply {
            binding.fragmentFormProgressPager.adapter = this
            pagerAdapter = this
        }

        binding.fragmentFormProgressPager.registerOnPageChangeCallback(ViewPagerPageChangeListener { position ->
            binding.fragmentFormProgressLayoutProgress.layoutProgressProgressbar.progress =
                ((position + 1) * 100 / pagerAdapter.itemCount)
            binding.fragmentFormProgressLayoutProgress.round = position + 1
        })
    }

    private fun showDialogs(isCorrect: Boolean, post: PostEntity) {
        if (isCorrect) {
            CorrectAnswerDialog(post, correctScreen) {
                scrollToNext()
            }.show(childFragmentManager, "")
        } else {
            WrongAnswerDialog(post, wrongScreen) {
                scrollToNext()
            }.show(childFragmentManager, "")
        }
    }

    private fun scrollToNext() {
        if (binding.fragmentFormProgressPager.currentItem + 1 == pagerAdapter.itemCount) {
            navController.navigate(
                FormProgressFragmentDirections.actionFormProgressFragmentToFinishFragment(navArgs.characterId)
            )
        }

        binding.fragmentFormProgressPager.setCurrentItem(
            binding.fragmentFormProgressPager.currentItem + 1,
            true
        )
    }
}