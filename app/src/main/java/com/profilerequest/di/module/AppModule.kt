package com.profilerequest.di.module

import com.profilerequest.data.repo.ProfileRepository
import com.profilerequest.data.repo.ProfileRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class,
    NetworkModule::class
])
abstract class AppModule {

    @Binds
    @Singleton
    internal abstract fun provideProfileRepository(profileRepository: ProfileRepositoryImpl): ProfileRepository
}