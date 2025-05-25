package com.apx.apx101.presentation.record

import androidx.lifecycle.ViewModel
import com.apx.templatev1.preference.PrefManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SViewModel @Inject constructor(
    private val prefManager: PrefManager
//    private val insertRecordUseCase: InsertRecordUseCase,
) : ViewModel() {

    /**
     * 앱초기실행여부
     * @desc 앱 초기 실행시, 데이터 관련 안내 팝업을 보여줄 용도로만 사용됨
     */
    private val _isFirstRun: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFirstRun: StateFlow<Boolean> = _isFirstRun

    /* Samples*/

//    private val _recordState = MutableStateFlow<CommonState<List<RecordModel>>>(CommonState.Loading)
//    val recordState: StateFlow<CommonState<List<RecordModel>>> = _recordState.asStateFlow()
//
//    private val _insertState = MutableStateFlow<CommonState<Unit>>(CommonState.Success(Unit))
//    val insertState: StateFlow<CommonState<Unit>> = _insertState.asStateFlow()
//
//    private val _clearState = MutableStateFlow<CommonState<Unit>>(CommonState.Success(Unit))
//    val clearState: StateFlow<CommonState<Unit>> = _clearState.asStateFlow()
//
//    init {
//        getIsFirstRun()
//        fetchAllRecords()
//    }
//
//    fun fetchAllRecords() {
//        viewModelScope.launch {
//            getAllRecordsUseCase()
//                .onStart { _recordState.value = CommonState.Loading }
//                .catch { e -> _recordState.value = CommonState.Error(e.message ?: "알 수 없는 오류") }
//                .collect { data ->
//                    _recordState.value = CommonState.Success(data)
//                }
//        }
//    }
//
//    fun insertRecord(record: RecordModel) {
//        viewModelScope.launch {
//            insertRecordUseCase(record)
//        }
//    }
//
//    fun clearAllRecords() {
//        viewModelScope.launch {
//            clearAllRecordsUseCase()
//            fetchAllRecords() // 삭제 후 목록 다시 갱신
//        }
//    }
//
//    /**
//     * GET : `앱 첫실행 여부`
//     * @desc 첫 실행여부를 저장
//     */
//    private fun getIsFirstRun() {
//        _isFirstRun.value = prefManager.getBoolean(IS_FIRST_RUN)
//    }
}
