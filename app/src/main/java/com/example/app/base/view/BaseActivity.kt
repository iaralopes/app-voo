package com.example.app.base.view

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.afollestad.materialdialogs.MaterialDialog
import com.example.app.R
import com.example.app.app.VooApplication
import com.example.app.app.di.ApplicationComponent
import com.example.app.base.viewModel.ViewModelFactory
import com.example.app.utils.DialogUtils
import java.lang.Exception
import javax.inject.Inject

open class BaseActivity : AppCompatActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var mProgress: MaterialDialog

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

        initProgress()

    }

    private fun initProgress() {
        mProgress = DialogUtils.createProgress(this)
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

    fun showProgress(isLoading : Boolean?){
        if(isLoading!!){
            showProgress()
        }else{
            hideProgress()
        }
    }

    fun showProgress() {
        try {
            mProgress.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hideProgress() {
        try {
            mProgress.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}