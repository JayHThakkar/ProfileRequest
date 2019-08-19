package com.profilerequest.data.model

import com.google.gson.annotations.SerializedName

data class RecentProfileResponse(
    @SerializedName("profile")
    val profile: ProfilePage
)