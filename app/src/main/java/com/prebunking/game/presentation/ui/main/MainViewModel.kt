package com.prebunking.game.presentation.ui.main

import androidx.lifecycle.*
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.domain.interactor.character.GetCharacters
import com.prebunking.game.domain.interactor.guest.CreateGuest
import com.prebunking.game.domain.interactor.screen.GetScreens
import com.prebunking.game.domain.interactor.session.CreateSession
import com.prebunking.game.presentation.model.CharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val createGuest: CreateGuest,
    private val getScreens: GetScreens,
    private val getCharacters: GetCharacters,
    private val createSession: CreateSession
) : ViewModel() {

    init {
        viewModelScope.launch {
            createGuest.execute()
        }
    }

    public val mainLoading: MutableLiveData<Boolean> = MutableLiveData()

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

    public val sessionCreated: MutableLiveData<Boolean> = MutableLiveData()

    public fun createSession(characterId: Int) {
        viewModelScope.launch {
            mainLoading.value = true
            try {
                createSession.execute(characterId)
                sessionCreated.value = true
            } catch (exception: Exception) {
                exception.printStackTrace()
            } finally {
                mainLoading.value = false
            }
        }
    }
}