package com.profilerequest.di.module

import com.profilerequest.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun contributeHomeActivity(): HomeActivity
}