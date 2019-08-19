package com.profilerequest.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.profilerequest.data.model.ProfilePage
import com.profilerequest.data.model.Work
import com.profilerequest.data.repo.ProfileRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val repository: ProfileRepository) : ViewModel() {

    private val profilesListLiveData = MutableLiveData<String>()
    private val profilesListWorkData = MutableLiveData<List<Work>>()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        getProfiles()
    }

    private fun getProfiles() {
        repository.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profilePage ->
                profilesListLiveData.value = profilePage?.name
                profilesListLiveData.value = profilePage?.email
                profilesListLiveData.value = profilePage?.phone
                profilesListLiveData.value = profilePage?.summary
                profilesListLiveData.value = profilePage?.technicalSkillSet
                profilesListWorkData.value =
                    profilePage?.workDetails
            }
            .let { compositeDisposable.add(it) }
    }

    fun getProfilesListLiveData() = profilesListLiveData
    fun getProfilesListWorkData() = profilesListWorkData

    override fun onCleared() {
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
        super.onCleared()
    }
}