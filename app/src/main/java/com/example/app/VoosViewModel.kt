package com.example.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.app.data.VoosResponse
import com.example.app.utils.FlowState
import javax.inject.Inject

class VoosViewModel @Inject constructor(private val voosInteractor: VoosInteractor): ViewModel() {

    private val voosState = MediatorLiveData<FlowState<VoosResponse>>()

    fun getVoos() {
        voosState.value = (FlowState(FlowState.Status.LOADING))
        voosState.addSource(voosInteractor.getVoos()){voosState.value = it}

    }

    fun voosState() : LiveData<FlowState<VoosResponse>> = voosState

}