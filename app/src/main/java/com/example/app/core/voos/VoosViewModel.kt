package com.example.app.core.voos

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.app.data.model.VoosResponse
import com.example.app.utils.FlowState
import javax.inject.Inject

class VoosViewModel @Inject constructor(private val voosInteractor: VoosInteractor): ViewModel() {

    private val voosState = MediatorLiveData<FlowState<VoosResponse>>()

    val amountVoos = ObservableField<String>()

    init {
        amountVoos.set("0")
    }


    fun getVoos() {
        voosState.value = (FlowState(FlowState.Status.LOADING))
        voosState.addSource(voosInteractor.getVoos()){voosState.value = it}

    }

    fun voosState() : LiveData<FlowState<VoosResponse>> = voosState

    fun setAmountVoos(amountVoos: Int) {
        this.amountVoos.set(amountVoos.toString())
    }

}