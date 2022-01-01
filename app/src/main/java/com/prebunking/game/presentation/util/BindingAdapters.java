package com.prebunking.game.presentation.util;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.prebunking.game.presentation.view.BaseListAdapter;

import java.util.List;

public class BindingAdapters {

    @BindingAdapter("android:loadData")
    public static void loadRecyclerData(RecyclerView recyclerView, List<?> data) {
        RecyclerView.Adapter<?> adapter = recyclerView.getAdapter();
        if (adapter instanceof BaseListAdapter) {
            ((BaseListAdapter) adapter).submitData(data);
        }
    }
}
