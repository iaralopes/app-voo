package com.example.app

import android.os.Bundle
import com.example.app.base.BaseActivity
import com.example.app.extension.viewModel

class VoosActivity : BaseActivity() {

    private lateinit var voosViewModel: VoosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voos)

        voosViewModel = viewModel(viewModelFactory)
    }
}
