package com.prebunking.game.presentation.ui.characters.list

import android.content.Context
import android.view.ViewGroup
import com.prebunking.game.R
import com.prebunking.game.databinding.ItemCharacterBinding
import com.prebunking.game.presentation.model.CharacterUI
import com.prebunking.game.presentation.view.BaseListAdapter
import com.prebunking.game.presentation.view.BaseViewHolder

class CharactersAdapter(
    val context: Context,
    val onCharacterClicked: (item: CharacterUI, position: Int) -> Unit
) : BaseListAdapter<CharacterUI, CharactersAdapter.CharacterViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(inflate(R.layout.item_character, parent, false))
    }

    inner class CharacterViewHolder(itemView: ItemCharacterBinding) :
        BaseViewHolder<CharacterUI, ItemCharacterBinding>(
            itemView
        ) {
        override fun onBind(item: CharacterUI?, position: Int) {
            binding.apply {
                character = item
                root.setOnClickListener { onCharacterClicked(item!!, position) }
            }
        }
    }

}