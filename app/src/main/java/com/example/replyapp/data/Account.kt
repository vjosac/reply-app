package com.example.replyapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Account(
    val id: Long,
    @StringRes val firstName: Int,
    @StringRes val lastName: Int,
    @StringRes val email: Int,
    @DrawableRes val avatar: Int? // todo: change to non-null after we add the drawable avatars
)
