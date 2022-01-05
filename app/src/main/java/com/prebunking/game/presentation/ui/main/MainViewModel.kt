package com.prebunking.game.presentation.ui.main

import androidx.lifecycle.*
import com.prebunking.game.domain.entity.ScreenEntity
import com.prebunking.game.domain.entity.SessionEntity
import com.prebunking.game.domain.interactor.character.GetCharacters
import com.prebunking.game.domain.interactor.guest.CreateGuest
import com.prebunking.game.domain.interactor.screen.GetScreens
import com.prebunking.game.domain.interactor.session.CreateSession
import com.prebunking.game.domain.interactor.session.PostSession
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
    private val createSession: CreateSession,
    private val postToSession: PostSession
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
            screensLoading.value = true
            screens.value = getScreens.execute()
                .catch { it.printStackTrace() }
                .single()
            screensLoading.value = false
        }
    }

    public val characters: MutableLiveData<List<CharacterUI>> = MutableLiveData()

    init {
        viewModelScope.launch {
            characters.value = getCharacters.execute()
                .catch { it.printStackTrace() }
                .single()
                .map { CharacterUI.fromDomain(it) }
        }
    }

    public val sessionCreated: MutableLiveData<SessionEntity> = MutableLiveData()

    public fun createSession(characterId: Int) {
        viewModelScope.launch {
            sessionCreated.value = createSession.execute(characterId)
                .onStart { mainLoading.value = true }
                .catch { it.printStackTrace() }
                .single()
            mainLoading.value = false
        }
    }

    public fun postToSession(postId: String, isCorrect: Boolean) {
        viewModelScope.launch {
            try {
                postToSession.execute(PostSession.PostSessionParams(postId, isCorrect))
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }
}