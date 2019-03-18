package com.example.app.core.voos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.app.data.remote.repository.RemoteRepository
import com.example.app.utils.CoroutineContextProvider
import com.example.app.utils.FlowState
import com.example.app.data.Result
import com.example.app.data.model.VoosResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class VoosInteractor @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val provider: CoroutineContextProvider

){
    private val resultGetVoos = MediatorLiveData<FlowState<VoosResponse>>()

    fun getVoos(): LiveData<FlowState<VoosResponse>> {

        GlobalScope.launch(provider.IO) {
            val resultRemote = remoteRepository.getVoos()
            handleRemoteResult(resultRemote)
        }

        return this.resultGetVoos
    }

    private fun handleRemoteResult(resultRemote: Result<VoosResponse>) {
        when (resultRemote) {
            is Result.Success -> {
                resultGetVoos.postValue(FlowState(FlowState.Status.SUCCESS, resultRemote.data))
            }
            is Result.Error -> {
                resultGetVoos.postValue(FlowState(FlowState.Status.ERROR, error = resultRemote.exception))
            }
        }
    }



}