package com.prebunking.game.data.api.model

import retrofit2.Response

typealias RemoteResponse<T> = Response<BaseResponse<T>>

class BaseResponse<T>(
    val meta: ResponseMeta?,
    val data: T?,
)

class ResponseMeta(
    val size: Int?
)