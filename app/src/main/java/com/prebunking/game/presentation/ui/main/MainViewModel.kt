package com.prebunking.game.presentation.ui.main

import androidx.lifecycle.*
import com.prebunking.game.domain.entity.CharacterEntity
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.domain.interactor.character.GetCharacters
import com.prebunking.game.domain.interactor.screen.GetScreens
import com.prebunking.game.presentation.model.CharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getScreens: GetScreens,
    getCharacters: GetCharacters
) : ViewModel() {

    public val screens: MutableLiveData<List<ScreenEntity>> = MutableLiveData()
    public val screensLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        viewModelScope.launch {
            screens.value = getScreens.execute()
                .onStart { screensLoading.value = true }
                .onCompletion { screensLoading.value = false }
                .catch { screensLoading.value = false }
                .single()
        }
    }

    public val characters: MutableLiveData<List<CharacterUI>> = MutableLiveData()
    public val charactersLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        viewModelScope.launch {
            characters.value = getCharacters.execute()
                .onStart { charactersLoading.value = true }
                .onCompletion { charactersLoading.value = false }
                .catch { charactersLoading.value = false }
                .single()
                .map { CharacterUI.fromDomain(it) }
        }
    }
}