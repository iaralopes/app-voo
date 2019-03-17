package com.example.app.app.di

import com.example.app.app.VooApplication
import com.example.app.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class]
)
interface ApplicationComponent {

    fun inject(application: VooApplication)
    fun inject(baseActivity: BaseActivity)
}