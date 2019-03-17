package com.example.app.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app.app.VooApplication
import com.example.app.app.di.ApplicationComponent
import com.example.app.base.viewModel.ViewModelFactory
import javax.inject.Inject

open class BaseActivity : AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var isLandscape = false

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as VooApplication).appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = if(!isLandscape) {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }else{
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }

        appComponent.inject(this)
    }

}