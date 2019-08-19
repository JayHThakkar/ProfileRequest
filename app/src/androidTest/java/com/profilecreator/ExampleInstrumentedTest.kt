package com.profilecreator

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
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

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository: ProfileRepository = mock()
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        viewModel = HomeViewModel(repository)
    }

    @Test
    fun onApplicationLoadGetDataFromServer() {
        val showProgressObserver = mock<Observer<List<Work>>>()
        viewModel.getProfilesLiveDataWorkSummery().observeForever(showProgressObserver)
        verify(showProgressObserver)
    }

    @Test
    fun onApplicationLoadGetProfileDataFromServer() {
        val showProgressObserver = mock<Observer<String>>()
        viewModel.getProfilesLiveDataName().observeForever(showProgressObserver)
        verify(showProgressObserver)
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.profilecreator", appContext.packageName)
    }
}
