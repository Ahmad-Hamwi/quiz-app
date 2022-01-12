package com.prebunking.game.presentation.ui.main

import android.view.View
import com.prebunking.game.R
import com.prebunking.game.databinding.ActivityMainBinding
import com.prebunking.game.presentation.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import android.view.WindowManager

import androidx.activity.viewModels
import androidx.navigation.NavDestination
import com.prebunking.game.presentation.ui.finish.FinishDialog


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    val viewModel: MainViewModel by viewModels()

    override fun bindLayoutBindings(binding: ActivityMainBinding) {
        binding.apply {
            layoutToolbar.toolbarButtonBack.setOnClickListener {
                onBackPressed()
            }
            this.viewModel = this@MainActivity.viewModel
        }
    }

    override fun setupTheme() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    override fun getMainNavHostFragmentId(): Int = R.id.main_nav_host_fragment

    override fun observeNavigation() {
        mainNavController?.addOnDestinationChangedListener { navController, destination, args ->
            if (destination.id == R.id.welcomeFragment || destination.id == R.id.thankYouFragment) {
                binding.layoutToolbar.toolbarButtonBack.visibility = View.GONE
            } else {
                binding.layoutToolbar.toolbarButtonBack.visibility = View.VISIBLE
            }
        }
    }

    private fun isDestinationBeforeSession(destination: NavDestination): Boolean =
        destination.id == R.id.welcomeFragment ||
                destination.id == R.id.charactersFragment ||
                destination.id == R.id.characterDetailsFragment ||
                destination.id == R.id.characterConfirmationFragment

    private fun isInSession(destination: NavDestination): Boolean =
        destination.id == R.id.formProgressFragment
                || destination.id == R.id.finishFragment
                || destination.id == R.id.thankYouFragment

    override fun onBackPressed() {
        if (isDestinationBeforeSession(mainNavController!!.currentDestination!!)) {
            super.onBackPressed()
        } else {
            showExitDialog()
        }
    }

    private fun showExitDialog() {
        FinishDialog { continuePlaying ->
            if (!continuePlaying) finish()
        }.show(supportFragmentManager, "")
    }
}