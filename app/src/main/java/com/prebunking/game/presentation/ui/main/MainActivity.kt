package com.prebunking.game.presentation.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.prebunking.game.R
import com.prebunking.game.databinding.ActivityMainBinding
import com.prebunking.game.presentation.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import android.view.WindowManager

import android.view.Window

import android.os.Build
import androidx.activity.viewModels


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun bindLayoutBindings(binding: ActivityMainBinding) {
        binding.apply {
            layoutToolbar.toolbarButtonBack.setOnClickListener {
                onBackPressed()
            }
        }
    }

    override fun setupTheme() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    override fun getMainNavHostFragmentId(): Int = R.id.main_nav_host_fragment

    val viewModel: MainViewModel by viewModels()

}