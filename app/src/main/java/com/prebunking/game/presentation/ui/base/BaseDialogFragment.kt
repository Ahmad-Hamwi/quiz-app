package com.prebunking.game.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.transition.MaterialSharedAxis

abstract class BaseDialogFragment<BINDING : ViewDataBinding> : DialogFragment() {
    protected lateinit var binding: BINDING

    protected lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            (DataBindingUtil.inflate(layoutInflater, getLayoutId(), container, false) as BINDING)
                .apply { bindLayoutBindings(this) }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = NavHostFragment.findNavController(this)
        setUpTransitions(view)
    }

    protected open fun setUpTransitions(view: View) {
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        returnTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)

        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected open fun bindLayoutBindings(binding: BINDING) {}
}