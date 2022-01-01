package com.prebunking.game.domain.entity

open class ScreenEntity(
    val id: Int?,
    val title: String?,
    val content: String?,
    val buttonMessage: String?,
    val buttonText: String?,
) {
    companion object {
        val WELCOME_SCREEN = 1
        val CHARACTER_LIST_SCREEN = 2
        val CHARACTER_DETAILS_SCREEN = 3
        val CHARACTER_CONFIRMATION_SCREEN = 4
        val POST_SCREEN = 5
        val CORRECT_ANSWER_SCREEN = 6
        val WRONG_ANSWER_SCREEN = 7
        val FINISH_SCREEN = 8
        val REDO_SCREEN = 9
        val THANK_YOU_SCREEN = 10
    }
}