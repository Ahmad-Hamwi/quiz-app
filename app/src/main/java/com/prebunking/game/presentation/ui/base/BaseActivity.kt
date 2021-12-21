package com.prebunking.game.presentation.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.prebunking.game.R

abstract class BaseActivity<BINDING : ViewDataBinding> : AppCompatActivity() {

    private lateinit var binding: BINDING

    private fun setContentLayoutWithBinding() {
        binding = DataBindingUtil
            .setContentView<BINDING>(this, R.layout.activity_main)
            .apply {
                lifecycleOwner = this@BaseActivity
                bindLayoutBindings(this)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayoutWithBinding()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    open fun bindLayoutBindings(binding: BINDING) {}
}