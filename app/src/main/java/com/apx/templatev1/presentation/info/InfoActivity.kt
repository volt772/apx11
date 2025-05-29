package com.apx.templatev1.presentation.info

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apx.templatev1.BuildConfig
import com.apx.templatev1.R
import com.apx.templatev1.presentation.ApxApp
import com.apx.templatev1.presentation.ext.BackButtonScaffoldScreen
import com.apx.templatev1.presentation.ext.SetStatusBarColor
import com.apx.templatev1.presentation.ext.openActivity
import com.apx.templatev1.presentation.opensource.OpenSourceActivity
import com.apx.templatev1.presentation.ui.theme.ApxTheme
import com.apx.templatev1.presentation.ui.theme.AxBlack
import com.apx.templatev1.presentation.ui.theme.AxDeepOrange200
import com.apx.templatev1.presentation.ui.theme.AxGray700
import com.apx.templatev1.presentation.ui.theme.AxWhite
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoActivity: ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApxTheme {
                SetStatusBarColor()
                InfoScreen(::infoBackPressed)
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
     * `오픈라이센스`메뉴 진입
     */
    private fun moveToOpenSource() {
        openActivity(OpenSourceActivity::class.java)
    }

    /**
     * 상단 앱바
     */
    @ExperimentalMaterial3Api
    @Composable
    fun InfoScreen(backPressed: () -> Unit) {
        /* TopBar*/
        BackButtonScaffoldScreen(
            title = stringResource(id = R.string.app_info),
            content = { InfoDisplay() },
            backPressed = backPressed
        )
    }

    /**
     * 본문 화면
     */
    @Composable
    fun InfoDisplay(
    ) {
        /**
         * @box Root
         */
        Column(
            modifier = Modifier.Companion
                .fillMaxSize()
                .background(AxGray700)
                .padding(20.dp, 100.dp, 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.Companion.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Companion.CenterHorizontally
            ) {

                /**
                 * @view 앱아이콘
                 */
                Image(
                    painterResource(id = R.drawable.ic_app_logo),
                    contentDescription = null,
                    modifier = Modifier.Companion
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(3.dp, AxDeepOrange200, CircleShape)
                )

                Spacer(modifier = Modifier.Companion.height(50.dp))

                /**
                 * @box 메뉴박스
                 */
                Column(
                    modifier = Modifier.Companion.fillMaxWidth(),
                    horizontalAlignment = Alignment.Companion.CenterHorizontally
                ) {
//                    /**
//                     * @box 오픈라이센스
//                     */
//                    Row(
//                        modifier = Modifier
//                            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
//                            .background(MgWhite)
//                            .fillMaxWidth()
//                            .height(56.dp)
//                            .clickable(
//                                interactionSource = remember { MutableInteractionSource() },
//                                indication = rememberRipple(bounded = false),
//                            ) {
//                                moveToOpenSource()
//                            },
//                        horizontalArrangement = Arrangement.Start,
//                        verticalAlignment = Alignment.CenterVertically,
//                    ) {
//                        /**
//                         * @view 레이블(오픈라이센스)
//                         */
//                        Text(
//                            modifier = Modifier.padding(horizontal = 18.dp),
//                            text = stringResource(id = R.string.opensource),
//                            fontSize = 16.sp,
//                            color = MgMenuFontBlack
//                        )
//                    }
//
//                    /**
//                     * @view 구분자
//                     * @info HorizontalDivider로 사용하면 1.dp시 색상지정을 못함
//                     */
//                    Spacer(modifier = Modifier.height(1.dp))

                    /**
                     * @box 앱버전
                     */
                    Row(
                        modifier = Modifier.Companion
                            .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp, bottomEnd = 8.dp, topEnd = 8.dp))
                            .background(AxWhite)
                            .fillMaxWidth()
                            .height(56.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Companion.CenterVertically
                    ) {
                        /**
                         * @view 레이블(앱버전)
                         */
                        Text(
                            modifier = Modifier.Companion.padding(start = 18.dp),
                            text = stringResource(id = R.string.app_version),
                            fontSize = 16.sp,
                            color = AxBlack
                        )

                        /**
                         * @view 앱버전(v1.0.0)
                         */
                        Text(
                            modifier = Modifier.Companion.padding(end = 18.dp),
                            text = stringResource(
                                id = R.string.app_version_template,
                                BuildConfig.VERSION_NAME
                            ),
                            fontSize = 16.sp,
                            color = AxBlack
                        )
                    }
                }
            }

            if (ApxApp.Companion.isDebugging == "Y") {
                Spacer(modifier = Modifier.Companion.height(20.dp))
                Column(
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    horizontalAlignment = Alignment.Companion.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        modifier = Modifier.Companion.padding(horizontal = 18.dp),
                        text = stringResource(id = R.string.on_debugging),
                        fontSize = 16.sp,
                        color = AxBlack
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewInfoScreen() {
        InfoDisplay(
        )
    }
}