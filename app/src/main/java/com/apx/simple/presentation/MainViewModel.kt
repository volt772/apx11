package com.apx.simple.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apx.simple.domain.constants.AppCodes
import com.apx.simple.preference.PrefManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val prefManager: PrefManager
): ViewModel() {

    private val _isFirstRun: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFirstRun: StateFlow<Boolean> = _isFirstRun

    init {
        getIsFirstRun()
    }


    fun setIsFirstRun() {
        viewModelScope.launch {
            prefManager.setBoolean(AppCodes.Pref.IS_FIRST_RUN, false)
        }
    }
    private fun getIsFirstRun() {
        _isFirstRun.value = prefManager.getBoolean(AppCodes.Pref.IS_FIRST_RUN)
    }
}