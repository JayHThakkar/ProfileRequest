package com.profilerequest.data.model

import com.google.gson.annotations.SerializedName

data class ProfilePage(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("technicalskillset")
    val technicalSkillSet: String,
    @SerializedName("work")
    val workDetails: List<Work>
)