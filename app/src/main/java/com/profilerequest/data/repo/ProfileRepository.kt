package com.profilerequest.data.repo

import com.profilerequest.data.model.ProfilePage
import io.reactivex.Single

interface ProfileRepository {
    fun getProfile(): Single<ProfilePage>
}