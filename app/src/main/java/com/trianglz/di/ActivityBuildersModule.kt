package com.trianglz.di

import com.trianglz.android_testing.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = []
    )
    abstract fun contributeUsersMainActivity(): MainActivity

}