package com.apx.simple.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.apx.simple.preference.PrefManager
import com.apx.simple.presentation.add.AddScreen
import com.apx.simple.presentation.detail.DetailScreen
import com.apx.simple.presentation.edit.EditScreen
import com.apx.simple.presentation.ext.SetStatusBarColor
import com.apx.simple.presentation.main.MainScreen
import com.apx.simple.presentation.ui.theme.ApxTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    /* PrefManager*/
    @Inject lateinit var prefManager: PrefManager

    /* ViewModel*/
    private lateinit var viewModel: MainViewModel

    /* IS FirstLaunch*/
    private var isFirstLaunch: Boolean = false

    /* BackPress (DoubleTap)*/
    private var backPressedTime: Long = 0
    private lateinit var backToast: Toast

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* 뒤로가기종료(Toast)*/
        backToast = Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT)

        /* 광고*/
        MobileAds.initialize(this)

        /* SplashScreen*/
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {
            false
        }

        setContent {
            /* Init VM*/
            viewModel = hiltViewModel()

            /* 스크롤 상태*/
            val scrollState = rememberScrollState()

            /* Navigation Controller*/
            val navController = rememberNavController()

            /* 뒤로가기(종료)*/
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry?.destination?.route
            BackHandler(enabled = currentRoute == "main") {
                val currentTime = System.currentTimeMillis()
                if (currentTime - backPressedTime <= 2000) {
                    backToast.cancel()
                    finish()
                } else {
                    backPressedTime = currentTime
                    backToast.show()
                }
            }

            ApxTheme {
                SetStatusBarColor()

                Box(modifier = Modifier.fillMaxSize()) {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "main",
                        modifier = Modifier.fillMaxSize() // ✅ 중요!
                    ) {
                        composable("main") {
                            MainScreen(
                                onAddClick = { navController.navigate("add") },
                            )

                            /* 예시*/
//                            MainScreen(
//                                viewModel = viewModel,
//                                onAddClick = { navController.navigate("add") },
//
//                                onItemClick = { subscription ->
//                                    navController.currentBackStackEntry?.savedStateHandle?.set("subscription", subscription);
//                                    navController.navigate("detail")
//                                },
//                                onDeleteClick = { subscription ->
//                                    subscriptionVM.delete(subscription)
//                                }
//                            )
                        }
                        composable(
                            "add",
                            enterTransition = { slideInHorizontally { it } + fadeIn() },
                            exitTransition = { slideOutHorizontally { it } + fadeOut() },
                            popEnterTransition = { slideInHorizontally { -it } + fadeIn() },
                            popExitTransition = { slideOutHorizontally { -it } + fadeOut() }
                        ) {
                            AddScreen()

                            /* 예시*/
//                            AddScreen(
//                                onBack = { navController.popBackStack() },
//                                onSave = { newModel ->
//                                    subscriptionVM.insert(newModel)
//                                    navController.popBackStack()
//                                }
//                            )
                        }
                        composable(
                            "detail",
                            enterTransition = { slideInHorizontally { it } + fadeIn() },
                            exitTransition = { slideOutHorizontally { it } + fadeOut() },
                            popEnterTransition = { slideInHorizontally { -it } + fadeIn() },
                            popExitTransition = { slideOutHorizontally { -it } + fadeOut() }
                        ) {
                            DetailScreen()

                            /* 예시*/
//                            val subscription = navController.previousBackStackEntry
//                                ?.savedStateHandle
//                                ?.get<SubscriptionModel>("subscription")
//
//                            subscription?.let { sb ->
//                                DetailScreen(
//                                    subscription = sb,
//                                    onBack = { navController.popBackStack() },
//                                    onEdit = {
//                                        navController.currentBackStackEntry?.savedStateHandle?.set("subscription", subscription);
//                                        navController.popBackStack()
//                                        navController.navigate("edit")
//                                    },
//                                    onDelete = { subscription ->
//                                        subscriptionVM.delete(subscription)
//                                        navController.popBackStack()
//                                    }
//                                )
//                            }
                        }
                        composable(
                            "edit",
                            enterTransition = { slideInHorizontally { it } + fadeIn() },
                            exitTransition = { slideOutHorizontally { it } + fadeOut() },
                            popEnterTransition = { slideInHorizontally { -it } + fadeIn() },
                            popExitTransition = { slideOutHorizontally { -it } + fadeOut() }
                        ) {
                            EditScreen()

                            /* 예시*/
//                            var subscription by remember { mutableStateOf<SubscriptionModel?>(null) }
//
//                            LaunchedEffect(Unit) {
//                                subscription = navController.previousBackStackEntry
//                                    ?.savedStateHandle
//                                    ?.get<SubscriptionModel>("subscription")
//                            }
//
//                            subscription?.let {
//                                AddSubscriptionScreen(
//                                    subscription = it,
//                                    onBack = { navController.popBackStack() },
//                                    onSave = { newModel ->
//                                        subscriptionVM.update(newModel)
//                                        navController.popBackStack()
//                                    }
//                                )
//                            }
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