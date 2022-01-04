package com.prebunking.game.presentation.ui.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.prebunking.game.R

abstract class BaseActivity<BINDING : ViewDataBinding> : AppCompatActivity() {

    private lateinit var binding: BINDING

    protected var mainNavController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupTheme()
        setContentLayoutWithBinding()
        setupMainNavigation()
        observeNavigation()
    }

    private fun setContentLayoutWithBinding() {
        binding = DataBindingUtil
            .setContentView<BINDING>(this, R.layout.activity_main)
            .apply {
                lifecycleOwner = this@BaseActivity
                bindLayoutBindings(this)
            }
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    open fun bindLayoutBindings(binding: BINDING) {}

    open fun setupTheme() {}

    private fun setupMainNavigation() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(getMainNavHostFragmentId()) as NavHostFragment
        mainNavController = navHostFragment.navController
    }

    protected open fun observeNavigation() {}

    @IdRes
    open fun getMainNavHostFragmentId(): Int = -1
}