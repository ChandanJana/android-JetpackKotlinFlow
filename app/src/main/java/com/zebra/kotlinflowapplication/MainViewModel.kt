package com.zebra.kotlinflowapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

/**
 * Created by Chandan Jana on 17-07-2023.
 * Company name: Mindteck
 * Email: chandan.jana@mindteck.com
 */
class MainViewModel : ViewModel() {

    val countDownFlow = flow<Int> {
        val startingValue = 10
        var countDown = startingValue
        emit(startingValue)
        while (countDown > 0){
            delay(1000)
            countDown--
            emit(countDown)
        }
    }

    init {
        collectFlow()
    }

    private fun collectFlow(){
        viewModelScope.launch {
            countDownFlow.collect{
                println("Current time is $it")
            }
        }
    }
}