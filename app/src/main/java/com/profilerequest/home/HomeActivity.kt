package com.profilerequest.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.profilerequest.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: HomeViewModel
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initRecyclerView()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        observeViewModelGetProfileData()
        observeViewModel()
    }

    private fun initRecyclerView() {
        profileAdapter = ProfileAdapter()
        rvProfile.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = profileAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeViewModel() {
        viewModel.getProfilesLiveDataWorkSummery().observe(this@HomeActivity, Observer { profiles ->
            if (profiles == null) return@Observer
            profileAdapter.setProfileDetails(profiles)
        })
    }

    private fun observeViewModelGetProfileData(){
        viewModel.getProfilesLiveDataName().observe(this@HomeActivity, Observer { profilr ->
            tvPersonName.text = profilr
        })
        viewModel.getProfilesLiveDataEmail().observe(this@HomeActivity, Observer { profilr ->
            tvPersonEmail.text = profilr
        })
        viewModel.getProfilesLiveDataPhone().observe(this@HomeActivity, Observer { profilr ->
            tvPersonPhone.text = profilr
        })
        viewModel.getProfilesLiveDataSummery().observe(this@HomeActivity, Observer { profilr ->
            tvPersonSummery.text = profilr
        })
        viewModel.getProfilesLiveDataSkill().observe(this@HomeActivity, Observer { profilr ->
            tvPersonSkillSet.text = profilr
        })
    }
}
