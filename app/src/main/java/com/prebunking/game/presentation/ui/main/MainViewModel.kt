package com.prebunking.game.presentation.ui.main

import androidx.lifecycle.*
import com.prebunking.game.domain.entity.CharacterEntity
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.domain.interactor.character.GetCharacters
import com.prebunking.game.domain.interactor.screen.GetScreens
import com.prebunking.game.presentation.model.CharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getScreens: GetScreens,
    getCharacters: GetCharacters
) : ViewModel() {

    val screens: LiveData<List<ScreenEntity>> =
        getScreens.execute()
            .asLiveData(viewModelScope.coroutineContext)

    val characters: LiveData<List<CharacterUI>> =
        getCharacters.execute()
            .map { list -> list.map { CharacterUI.fromDomain(it) } }
            .catch { e -> e.printStackTrace() }
            .asLiveData(viewModelScope.coroutineContext)

}