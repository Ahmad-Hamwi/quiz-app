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
import com.prebunking.game.presentation.model.SessionUI
import com.prebunking.game.presentation.util.add
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

    val mainLoading: MutableLiveData<Boolean> = MutableLiveData()

    val screens: MutableLiveData<List<ScreenEntity>> = MutableLiveData()
    val screensLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        viewModelScope.launch {
            screensLoading.value = true
            screens.value = getScreens.execute()
                .catch { it.printStackTrace() }
                .single()
            screensLoading.value = false
        }
    }

    val characters: MutableLiveData<List<CharacterUI>> = MutableLiveData()

    init {
        viewModelScope.launch {
            characters.value = getCharacters.execute()
                .catch { it.printStackTrace() }
                .single()
                .map { CharacterUI.fromDomain(it) }
        }
    }

    val sessionCreated: MutableLiveData<SessionUI> = MutableLiveData()

    fun createSession(characterId: Int) {
        viewModelScope.launch {
            sessionCreated.value = createSession.execute(characterId)
                .onStart { mainLoading.value = true }
                .catch { it.printStackTrace() }
                .map { SessionUI.fromDomain(it) }
                .single()
            mainLoading.value = false
        }
    }

    fun postToSession(postId: String, isCorrect: Boolean) {
        if (isCorrect) {
            val badge = sessionCreated.value!!.posts.first { it.id == postId }.badge
            sessionCreated.value!!.obtainedBadges.add(badge)
        }

        viewModelScope.launch {
            try {
                postToSession.execute(PostSession.PostSessionParams(postId, isCorrect))
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
        }
    }
}