package com.apx.simple.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.apx.simple.preference.PrefManager
import com.apx.simple.presentation.ads.BannersAds
import com.apx.simple.presentation.ext.SetStatusBarColor
import com.apx.simple.presentation.ui.theme.ApxTheme
import com.apx.simple.presentation.ui.theme.AxRed200
import com.apx.simple.presentation.ui.theme.AxRed300
import com.apx.simple.presentation.ui.theme.AxRed400
import com.apx.simple.presentation.ui.theme.AxRed500
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    @Inject
    lateinit var prefManager: PrefManager

    private lateinit var viewModel: MainViewModel

    private var isFirstLaunch: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* 광고*/
        MobileAds.initialize(this)

        /* SplashScreen*/
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {
            false
        }

        setContent {

            viewModel = hiltViewModel()

            /* 스크롤 상태*/
            val scrollState = rememberScrollState()

            ApxTheme {
                SetStatusBarColor()

                /**
                 * ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼
                 * 템플릿작성 (아래는 예시)
                 */

                /**
                 * @box Root
                 */
                Column(
                    modifier = Modifier.Companion
                        .fillMaxSize()
                        .background(AxRed200),
                ) {

                    /**
                     * @box 배너광고
                     */
                    Column(
                        modifier = Modifier.background(AxRed300)
                    ) {
                        BannersAds()
                    }

                    /**
                     * @box Root(Content)
                     */
                    Column(
                        modifier = Modifier.Companion
                            .fillMaxSize()
                            .verticalScroll(state = scrollState)
                            .background(AxRed400),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        /**
                         * @box Root(Content)
                         */
                        Column(
                            modifier = Modifier.Companion.background(AxRed500)
                        ) {

                        }
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewAppInfo() {
    }
}