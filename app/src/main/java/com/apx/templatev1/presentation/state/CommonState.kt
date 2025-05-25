package com.apx.templatev1.presentation.state

sealed class CommonState<out T> {
    object Loading : CommonState<Nothing>()
    data class Success<T>(val data: T) : CommonState<T>()
    data class Error(val message: String) : CommonState<Nothing>()
}