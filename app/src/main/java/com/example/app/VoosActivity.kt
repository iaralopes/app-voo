package com.example.app

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.app.base.BaseActivity
import com.example.app.data.VoosResponse
import com.example.app.databinding.ActivityVoosBinding
import com.example.app.extension.viewModel
import com.example.app.utils.FlowState

class VoosActivity : BaseActivity() {

    private lateinit var voosViewModel: VoosViewModel
    private lateinit var voosBinding: ActivityVoosBinding

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
//                showProgress(true)
            }
            FlowState.Status.SUCCESS -> state.data?.let {

//                workOrdersAdapter = WorkOrdersAdapter(it, it.map { it -> getStatusString(it.status) }, this)
//                binding.recyclerView.adapter = workOrdersAdapter
//                workOrdersAdapter.notifyDataSetChanged()

            }
            FlowState.Status.ERROR -> {
//                if (workOrdersAdapter?.list.isEmpty()) {
//                    showErrorDialog(getString(R.string.no_inspection_error))
//                }
            }
        }
    }
}
