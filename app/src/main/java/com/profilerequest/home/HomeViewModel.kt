package com.profilerequest.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.profilerequest.data.model.Work
import com.profilerequest.data.repo.ProfileRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val repository: ProfileRepository) : ViewModel() {

    private val profilesLiveDataWorkSummery = MutableLiveData<List<Work>>()
    private val profilesLiveDataName = MutableLiveData<String>()
    private val profilesLiveDataEmail = MutableLiveData<String>()
    private val profilesLiveDataPhone = MutableLiveData<String>()
    private val profilesLiveDataSummery = MutableLiveData<String>()
    private val profilesLiveDataSkill = MutableLiveData<String>()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        getCandidateCompanyData()
        getCandidateName()
        getCandidateEmail()
        getCandidatePhone()
        getCandidateSummery()
        getCandidateTechnicalSkill()
    }

    private fun getCandidateCompanyData() {
        repository.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profilePage ->
                profilesLiveDataWorkSummery.value =
                    profilePage?.workDetails
            }
            .let { compositeDisposable.add(it) }
    }

    private fun getCandidateName() {
        repository.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profilePage -> profilesLiveDataName.value = profilePage?.name }
            .let { compositeDisposable.add(it) }
    }

    private fun getCandidateEmail() {
        repository.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profilePage -> profilesLiveDataEmail.value = profilePage?.email }
            .let { compositeDisposable.add(it) }
    }

    private fun getCandidatePhone() {
        repository.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profilePage -> profilesLiveDataPhone.value = profilePage?.phone }
            .let { compositeDisposable.add(it) }
    }

    private fun getCandidateSummery() {
        repository.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profilePage -> profilesLiveDataSummery.value = profilePage?.summary }
            .let { compositeDisposable.add(it) }
    }

    private fun getCandidateTechnicalSkill() {
        repository.getProfile()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { profilePage -> profilesLiveDataSkill.value = profilePage?.technicalSkillSet }
            .let { compositeDisposable.add(it) }
    }

    fun getProfilesLiveDataWorkSummery() = profilesLiveDataWorkSummery
    fun getProfilesLiveDataName() = profilesLiveDataName
    fun getProfilesLiveDataEmail() = profilesLiveDataEmail
    fun getProfilesLiveDataPhone() = profilesLiveDataPhone
    fun getProfilesLiveDataSummery() = profilesLiveDataSummery
    fun getProfilesLiveDataSkill() = profilesLiveDataSkill


    override fun onCleared() {
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
        super.onCleared()
    }
}