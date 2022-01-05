package com.prebunking.game.data.api.requests

class PostSessionBody(
    val sessionId: String,
    val postId: String,
    val isCorrect: Int
)