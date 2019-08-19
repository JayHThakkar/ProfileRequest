package com.profilerequest.data.api

import com.profilerequest.data.model.RecentProfileResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ProfileApi {

    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/JayHThakkar/dd63bd12ba85eaf1a727c09da4162852/raw/08f94d35fe04c29bb355e888b89b4a0953bbc2bd/profile.json/"
    }

    @GET(".")
    fun getRecent(): Single<RecentProfileResponse>
}