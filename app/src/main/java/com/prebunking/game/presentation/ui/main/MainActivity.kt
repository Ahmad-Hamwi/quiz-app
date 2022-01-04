package com.prebunking.game.presentation.ui.main

import com.prebunking.game.R
import com.prebunking.game.databinding.ActivityMainBinding
import com.prebunking.game.presentation.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import android.view.WindowManager

import androidx.activity.viewModels
import androidx.navigation.NavDestination


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
        mainNavController?.addOnDestinationChangedListener { controller, destination, arguments ->
            if (isDestinationBeforeSession(destination)) {
                viewModel.sessionCreated.value = false
            }
        }
    }

    private fun isDestinationBeforeSession(destination: NavDestination): Boolean =
        destination.id == R.id.welcomeFragment ||
                destination.id == R.id.charactersFragment ||
                destination.id == R.id.characterDetailsFragment ||
                destination.id == R.id.characterConfirmationFragment
}