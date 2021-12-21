package com.prebunking.game.presentation.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.prebunking.game.R
import com.prebunking.game.databinding.ActivityMainBinding
import com.prebunking.game.presentation.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var mainNavController: NavController

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun bindLayoutBindings(binding: ActivityMainBinding) {
        binding.apply {
            layoutToolbar.toolbarButtonBack.setOnClickListener {
                onBackPressed()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupMainNavigation()
    }

    private fun setupMainNavigation() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        mainNavController = navHostFragment.navController
    }
}