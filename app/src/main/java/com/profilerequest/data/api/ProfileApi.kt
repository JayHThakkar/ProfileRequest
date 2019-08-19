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

   /* @GET("rest/?method=flickr.photos.search&api_key=$API_KEY" +
            "&extras=owner_name,icon_server,icon_farm&format=json&nojsoncallback=1")
    fun search(
        @Query("tags") query: String,
        @Query("per_page") perPage: Int = 50): Single<RecentProfileResponse>*/
}

//https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=6bf318919bbbc455f3573d18798a58e3&extras=owner_name,icon_server,icon_farm&format=json&nojsoncallback=1&per_page=50