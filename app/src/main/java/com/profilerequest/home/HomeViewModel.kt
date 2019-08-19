package com.profilerequest.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.profilerequest.data.model.Work
import com.profilerequest.data.repo.ProfileRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val repository: ProfileRepository): ViewModel() {

    private val profilesListLiveData = MutableLiveData<List<Work>>()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        getProfiles()
    }

    private fun getProfiles() {
        repository.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profilePage -> profilesListLiveData.value = profilePage?.workDetails;profilePage?.name;profilePage?.email;profilePage?.phone;profilePage?.summary;profilePage?.technicalSkillSet}
            .let { compositeDisposable.add(it) }
    }

    fun getProfilesListLiveData() = profilesListLiveData

    override fun onCleared() {
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
        super.onCleared()
    }
}