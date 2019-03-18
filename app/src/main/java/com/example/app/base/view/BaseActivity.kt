package com.example.app.base.view

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.app.R
import com.example.app.app.VooApplication
import com.example.app.app.di.ApplicationComponent
import com.example.app.base.viewModel.ViewModelFactory
import java.lang.Exception
import javax.inject.Inject

open class BaseActivity : AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var isLandscape = false
    private lateinit var mToolbar: Toolbar

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

    protected fun setUpToolbar(toolbar: Toolbar, title: String) {
        setSupportActionBar(toolbar)
        supportActionBar.let {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
            toolbar.setNavigationOnClickListener { onBackPressed() }
            mToolbar = toolbar
            setTitleToolbar(title)
        }
    }


    fun setTitleToolbar(title: String) {
        try {
            (mToolbar.findViewById(R.id.toolbar_title) as TextView).text = title
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}