package com.profilerequest.di.component

import com.profilerequest.ProfileApplication
import com.profilerequest.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent: AndroidInjector<ProfileApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<ProfileApplication>()
}