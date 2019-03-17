package com.example.app.app

import android.app.Application
import com.example.app.app.di.ApplicationComponent
import com.example.app.app.di.ApplicationModule
import com.example.app.app.di.DaggerApplicationComponent

class VooApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)

}