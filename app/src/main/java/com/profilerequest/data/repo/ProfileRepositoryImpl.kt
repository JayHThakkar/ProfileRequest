package com.profilerequest.data.repo

import com.profilerequest.data.api.ProfileApi
import com.profilerequest.data.model.ProfilePage
import io.reactivex.Single
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(val profileApi: ProfileApi) : ProfileRepository {
    override fun getProfile(): Single<ProfilePage> {
        return profileApi.getRecent()
            .map { it.profile }
    }
}