package com.example.app

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.app.adapter.VoosAdapter
import com.example.app.base.BaseActivity
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
}
