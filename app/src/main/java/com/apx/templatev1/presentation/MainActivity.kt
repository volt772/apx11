package com.apx.templatev1.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.apx.templatev1.preference.PrefManager
import com.apx.templatev1.presentation.ApxApp.Companion.adMobKey
import com.apx.templatev1.presentation.ext.SetStatusBarColor
import com.apx.templatev1.presentation.ui.theme.ApxTheme
import com.apx.templatev1.presentation.ui.theme.AxRed200
import com.apx.templatev1.presentation.ui.theme.AxRed300
import com.apx.templatev1.presentation.ui.theme.AxRed400
import com.apx.templatev1.presentation.ui.theme.AxRed500
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    @Inject
    lateinit var prefManager: PrefManager

    private val vm: MainViewModel by viewModels()
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

        lifecycleScope.run {
            /**
             * 첫 실행 여부 확인
             * @use 첫실행시, 사용자에게 안내문구 다이얼로그를 1회 보여주어야 한다.
             * @use 사용자가 확인누르면 데이터 초기화 및 앱재설치시까지 다이얼로그를 보여주지 않는다.
             */
            launch {
                repeatOnLifecycle(Lifecycle.State.CREATED) {
                    vm.isFirstRun.collectLatest { isFirst ->
                        isFirstLaunch = isFirst
                    }
                }
            }

//            launch {
//                vm.currentStadium.collectLatest { stadium ->
//                    currentStadium = stadium
//                    vm.fetch(stadium)
//                }
//            }
        }

        setContent {
            /* 스크롤 상태*/
            val scrollState = rememberScrollState()

            /* 다이얼로그 상태*/
//            val openAlertDialog = remember { mutableStateOf(isFirstLaunch) }

            /**
             * OpenAlertDialog
             * @desc 첫 실행시 안내문구 (앱 사용중 최초1회만 노출)
             * @action `확인` Preference에 첫실행여부 플래그 Boolean값 설정
             */
//            if (openAlertDialog.value) {
//                AppInfoDialog(
//                    onDismissRequest = { },
//                    onConfirmation = {
//                        openAlertDialog.value = false
//                        vm.setIsFirstRun()
//                    },
//                    dialogTitle = stringResource(id = R.string.welcome),
//                    dialogText = stringResource(id = R.string.inaccurate_info1),
//                    icon = Icons.Default.Face,
//                    buttonConfirmLabel = stringResource(id = R.string.confirmed)
//                )
//            }

            ApxTheme {
                SetStatusBarColor()

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

    /* Samples*/
//    @Composable
//    fun RenderCurrentWeatherScreen() {
//        /* Column1 : Current Screen*/
//        when (val state = vm.currentWeather.collectAsStateWithLifecycle().value) {
//            is CommonState.Loading -> {
//                LoadingProgressIndicator()
//            }
//
//            is CommonState.Error -> {
//                vm.isFailed = true
//            }
//            is CommonState.Success -> {
//                vm.onLoading = false
//
//                if (!vm.isFailed) {
//                    /**
//                     * @box Root
//                     */
//                    CurrentWeatherScreen(
//                        info = state.data,
//                        currentStadium = currentStadium,
//                        doSelectStadium = ::setCurrentStadium,
//                        modifier = Modifier
//                    )
//                }
//            }
//        }
//    }

//    @Composable
//    fun RenderAppInfo() {
//        /**
//         * @box Root
//         */
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(MgDarkBlue)
//                .padding(end = 10.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            /**
//             * @view 안내문구
//             */
//            Text(
//                modifier = Modifier.padding(horizontal = 10.dp),
//                text = stringResource(id = R.string.inaccurate_info2),
//                fontSize = 16.sp,
//                color = MgYellow,
//                textAlign = TextAlign.Center
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//            /**
//             * @view `앱정보` 버튼
//             * @use `앱정보` 메뉴진입
//             */
//            Button(
//                colors = ButtonColors(
//                    containerColor = MgSubDarkBlue,
//                    contentColor = MgWhite,
//                    disabledContainerColor = MgSubDarkBlue,
//                    disabledContentColor = MgWhite,
//                ),
//                onClick = {
//                    openActivity(InfoActivity::class.java)
//                }
//            ) {
//                Text(text = stringResource(id = R.string.app_info))
//            }
//            Spacer(modifier = Modifier.height(20.dp))
//        }
//    }

    /**
     * BannerAds
     */
    @Composable
    fun BannersAds() {
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)

                    adUnitId = adMobKey
                    loadAd(AdRequest.Builder().build())
                }
            },
            update = { adView ->
                adView.loadAd(AdRequest.Builder().build())
            }
        )
    }

    @Preview
    @Composable
    fun PreviewAppInfo() {
//        RenderAppInfo()
    }
}