package com.profilecreator

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.InstrumentationRegistry
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.profilerequest.data.model.Work
import com.profilerequest.data.repo.ProfileRepository
import com.profilerequest.home.HomeViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class ExampleUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository: ProfileRepository = mock()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        viewModel = HomeViewModel(repository)
    }

    @Test
    fun onApplicationLoadGetProfilesLiveDataName() {
        val showProgressObserver = mock<Observer<String>>()
        viewModel.getProfilesLiveDataName().observeForever(showProgressObserver)
        viewModel.getCandidateName()
        verify(showProgressObserver)
    }

    @Test
    fun onApplicationLoadGetCandidateEmail() {
        val showProgressObserver = mock<Observer<String>>()
        viewModel.getProfilesLiveDataEmail().observeForever(showProgressObserver)
        viewModel.getCandidateEmail()
        verify(showProgressObserver)
    }

    @Test
    fun onApplicationLoadGetProfilesLiveDataPhone() {
        val showProgressObserver = mock<Observer<String>>()
        viewModel.getProfilesLiveDataPhone().observeForever(showProgressObserver)
        viewModel.getCandidatePhone()
        verify(showProgressObserver)
    }

    @Test
    fun onApplicationLoadGetProfilesLiveDataSummery() {
        val showProgressObserver = mock<Observer<String>>()
        viewModel.getProfilesLiveDataSummery().observeForever(showProgressObserver)
        viewModel.getCandidateSummery()
        verify(showProgressObserver)
    }

    @Test
    fun onApplicationLoadGetCandidateTechnicalSkill() {
        val showProgressObserver = mock<Observer<String>>()
        viewModel.getProfilesLiveDataSkill().observeForever(showProgressObserver)
        viewModel.getCandidateTechnicalSkill()
        verify(showProgressObserver)
    }

    @Test
    fun onApplicationLoadGetProfilesLiveDataWorkSummery() {
        val showProgressObserver = mock<Observer<List<Work>>>()
        viewModel.getProfilesLiveDataWorkSummery().observeForever(showProgressObserver)
        viewModel.getCandidateCompanyData()
        verify(showProgressObserver)
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.profilecreator", appContext.packageName)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}