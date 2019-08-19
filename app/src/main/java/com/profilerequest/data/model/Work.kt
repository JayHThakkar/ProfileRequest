package com.profilerequest.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Work(
    @SerializedName("company")
    val company: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("role")
    val role: String
) : Parcelable