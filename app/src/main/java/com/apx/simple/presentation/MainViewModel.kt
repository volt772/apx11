package com.apx.simple.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
            prefManager.setBoolean("IsFirstRun", false)
        }
    }
    private fun getIsFirstRun() {
        _isFirstRun.value = prefManager.getBoolean("IsFirstRun")
    }

    /* CRUD+Search Example*/
//    fun getAllProducts() {
//        viewModelScope.launch {
//            productUseCase.getAllProducts()
//                .onStart { _productState.value = CommonState.Loading }
//                .catch { e -> _productState.value = CommonState.Error(e.message?: "Unknown Error") }
//                .collect { list -> _productState.value = CommonState.Success(list) }
//        }
//    }
//
//    fun searchProduct(query: String) {
//        _searchQuery.value = query
//        viewModelScope.launch {
//            productUseCase.searchProductByName(query)
//                .onStart { _productState.value = CommonState.Loading }
//                .catch { e -> _productState.value = CommonState.Error(e.message ?: "Unknown error") }
//                .collect { list -> _productState.value = CommonState.Success(list) }
//        }
//    }
//
//    fun insertProduct(product: ProductModel) {
//        viewModelScope.launch {
//            productUseCase.insertProduct(product)
//
//            _productState.value = CommonState.Loading
//            productUseCase.getAllProducts()
//                .collect {
//                    _productState.value = CommonState.Success(it)
//                }
//        }
//    }
//
//    fun updateProduct(product: ProductModel) {
//        viewModelScope.launch {
//            productUseCase.updateProduct(product)
//        }
//    }
//
//    fun deleteProduct(product: ProductModel) {
//        viewModelScope.launch {
//            productUseCase.deleteProduct(product)
//        }
//    }

}