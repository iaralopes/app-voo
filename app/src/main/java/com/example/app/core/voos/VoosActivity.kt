package com.example.app.core.voos

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.app.R
import com.example.app.adapter.VoosAdapter
import com.example.app.app.Constants.Extras.Companion.RESULT_ORDENATION_EXTRA_BUNDLE
import com.example.app.base.BaseActivity
import com.example.app.core.ordenation.OrdenationActivity
import com.example.app.core.ordenation.OrdenationVoosTypes
import com.example.app.data.VoosResponse
import com.example.app.data.mapper.VooMapper
import com.example.app.databinding.ActivityVoosBinding
import com.example.app.extension.viewModel
import com.example.app.utils.FlowState

class VoosActivity : BaseActivity() {

    private lateinit var voosViewModel: VoosViewModel
    private lateinit var voosBinding: ActivityVoosBinding
    private lateinit var voosAdapter: VoosAdapter

    private lateinit var voosRemoteResult: VoosResponse

    companion object {
        const val ORDENATION_REQUEST_CODE = 222
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voos)

        voosViewModel = viewModel(viewModelFactory)
        voosBinding = DataBindingUtil.setContentView(this, R.layout.activity_voos)
        voosBinding.viewModel = voosViewModel

        voosViewModel.getVoos()
        setObservableViewModel()
    }

    private fun setObservableViewModel() {
        voosViewModel.voosState().observe(this,
            Observer { it?.let { handleVoosState(it) } })
    }

    private fun handleVoosState(state: FlowState<VoosResponse>) {
        when (state.status) {
            FlowState.Status.LOADING -> {
            }
            FlowState.Status.SUCCESS -> state.data?.let {

                voosRemoteResult = it

                voosAdapter = VoosAdapter(VooMapper.parseInboundListToAdaptedList(it))
                voosBinding.recyclerView.adapter = voosAdapter
                voosAdapter.notifyDataSetChanged()


            }
            FlowState.Status.ERROR -> {
            }
        }
    }

    fun onClickOutboundVoos(view: View) {
        voosAdapter.list = VooMapper.parseOutboundListToAdaptedList(voosRemoteResult)
        voosAdapter.notifyDataSetChanged()
    }

    fun onClickInboundVoos(view: View) {
        voosAdapter.list = VooMapper.parseInboundListToAdaptedList(voosRemoteResult)
        voosAdapter.notifyDataSetChanged()
    }

    fun onClickOrdenation(view: View) {
        val intent = Intent(this, OrdenationActivity::class.java)
        startActivityForResult(intent, ORDENATION_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ORDENATION_REQUEST_CODE && resultCode == RESULT_OK) {
            var result = data?.getStringExtra(RESULT_ORDENATION_EXTRA_BUNDLE).toString()
            when (result) {
                OrdenationVoosTypes.BIGGEST_PRICE.ordenation -> {
                    voosAdapter.list = voosAdapter.list.sortedByDescending { it.pricing.ota?.saleTotal }
                }
                OrdenationVoosTypes.LOWEST_PRICE_SHORTER_TIME.ordenation -> {
                    voosAdapter.list = voosAdapter.list.sortedWith(compareBy({ it.pricing.ota?.saleTotal },
                        { it.duration }))
                }
                OrdenationVoosTypes.LOWEST_PRICE.ordenation -> {
                    voosAdapter.list = voosAdapter.list.sortedBy { it.pricing.ota?.saleTotal }
                }
            }

            voosAdapter.notifyDataSetChanged()
        }
    }

}