package com.apx.templatev1.presentation.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.apx.apx101.presentation.record.SViewModel
import com.apx.templatev1.presentation.ext.BackButtonScaffoldScreen
import com.apx.templatev1.presentation.ext.SetStatusBarColor
import com.apx.templatev1.presentation.ui.theme.ApxTheme
import com.apx.templatev1.presentation.ui.theme.AxRed200
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SActivity: ComponentActivity() {

    private val vm: SViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ApxTheme {
                SetStatusBarColor()
                RecordScreen(::infoBackPressed)
            }
        }
    }

    /**
     * 뒤로가기 Listener
     */
    private fun infoBackPressed() {
        onBackPressedDispatcher.onBackPressed()
    }

    /**
     * 상단 앱바
     */
    @ExperimentalMaterial3Api
    @Composable
    fun RecordScreen(backPressed: () -> Unit) {
        /* TopBar*/
        BackButtonScaffoldScreen(
            title = "정산기록",
            content = { RecordDisplay() },
            backPressed = backPressed
        )
    }

    /**
     * 본문 화면
     */
    @Composable
    fun RecordDisplay() {
        /* Samples*/
//        when (val state = vm.recordState.collectAsState().value) {
//            is CommonState.Loading -> {
//                LoadingProgressIndicator()
//            }
//            is CommonState.Error -> {
//                Box(
//                    modifier = Modifier.Companion.fillMaxSize(),
//                    contentAlignment = Alignment.Companion.Center
//                ) {
//                    Column(horizontalAlignment = Alignment.Companion.CenterHorizontally) {
//                        Text(
//                            text = "데이터 로드 중 오류가 발생했습니다.",
//                            color = Color.Companion.Red
//                        )
//                        Spacer(modifier = Modifier.Companion.height(8.dp))
//                        Button(onClick = { vm.fetchAllRecords() }) {
//                            Text("다시 시도")
//                        }
//                    }
//                }
//            }
//            is CommonState.Success<*> -> {
//                //
//            }
//        }
    }

    /**
     * LoadingProgress
     */
    @Composable
    private fun LoadingProgressIndicator() {
        Column(
            modifier = Modifier.Companion.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier.Companion.size(30.dp, 30.dp),
                strokeCap = StrokeCap.Companion.Round,
                color = AxRed200
            )
        }
    }

}