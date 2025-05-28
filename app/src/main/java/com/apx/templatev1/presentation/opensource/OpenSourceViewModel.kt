package com.apx.templatev1.presentation.opensource

import android.content.Context
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OpenSourceViewModel @Inject constructor(
    private val context: Context,
): ViewModel() {

    /* 오픈소스 정보*/
//    private val _openSource: MutableStateFlow<CommonState<List<OpenSourceDto>>> = MutableStateFlow(CommonState.Loading())
//    val openSource: StateFlow<CommonState<List<OpenSourceDto>>> = _openSource
//
//    init {
//        composeOpenSources()
//    }
//
//    /**
//     * 오픈소스 생성
//     */
//    private fun composeOpenSources() {
//        viewModelScope.launch {
//            val source = mutableListOf<OpenSourceDto>().also { list ->
//                context.resources.getStringArray(R.array.licenses).forEach { os ->
//                    list.add(
//                        OpenSourceDto(
//                            name = os,
//                            description = getLicenseContent(os),
//                        )
//                    )
//                }
//            }.toList()
//
//            flowOf(Resource.Success(source))
//                .map { resource -> CommonState.Companion.fromResource(resource) }
//                .collect { state -> _openSource.value = state }
//        }
//    }
//
//    /**
//     * 오픈소스 내용 파싱
//     */
//    private fun getLicenseContent(licenseName: String): String {
//        val licenseRes = StringBuilder()
//        try {
//            val filePath = "licenses/$licenseName"
//            context.assets.open(filePath).bufferedReader().use {
//                val line = it.readText()
//                licenseRes.append(line)
//            }
//        } catch (e: IOException) {
//            return ""
//        }
//
//        return licenseRes.toString()
//    }
}