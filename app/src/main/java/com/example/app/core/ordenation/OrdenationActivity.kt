package com.example.app.core.ordenation

import android.os.Bundle
import android.view.View
import com.example.app.R
import com.example.app.app.Constants.Extras.Companion.RESULT_ORDENATION_EXTRA_BUNDLE
import com.example.app.base.view.BaseActivity
import kotlinx.android.synthetic.main.activity_ordenation.radio_group
import kotlinx.android.synthetic.main.partial_toolbar.*

class OrdenationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordenation)

        setUpToolbar(toolbar, "ORDENAÇÃO")


    }

    fun onClickOrdenation(view: View) {
        getOrdenationOption(radio_group.checkedRadioButtonId)

    }

    private fun getOrdenationOption(checkedRadioButton: Int) {
        when (checkedRadioButton) {
            R.id.lowest_price_button -> intent.putExtra(RESULT_ORDENATION_EXTRA_BUNDLE, OrdenationVoosTypes.LOWEST_PRICE.ordenation)
            R.id.lowest_price_shorter_time_button -> intent.putExtra(RESULT_ORDENATION_EXTRA_BUNDLE, OrdenationVoosTypes.LOWEST_PRICE_SHORTER_TIME.ordenation)
            R.id.biggest_price_button -> intent.putExtra(RESULT_ORDENATION_EXTRA_BUNDLE, OrdenationVoosTypes.BIGGEST_PRICE.ordenation)
        }

        setResult(RESULT_OK, intent)
        finish()
    }
}
