package com.apx.simple.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.apx.simple.presentation.ads.BannersAds
import com.apx.simple.presentation.ui.theme.AxPrimary
import com.apx.simple.presentation.ui.theme.AxWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
//    viewModel: MainViewModel,
    onAddClick: () -> Unit,
//    onItemClick: (SubscriptionModel) -> Unit,
//    onDeleteClick: (SubscriptionModel) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AxWhite)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(text = "MAIN SCREEN")

            FloatingActionButton(
                onClick = { onAddClick() },
                shape = CircleShape,
                containerColor = AxPrimary,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add", tint = AxWhite)
            }
        }

        // 하단 고정 배너 광고
        BannersAds()
    }

}

///////////////////////////////////////////////////////////////////////////////////////////////////
// SAMPLE
///////////////////////////////////////////////////////////////////////////////////////////////////

//val subscriptions by viewModel.subscriptions.collectAsState()
//var isSearching by remember { mutableStateOf(false) }
//var query by remember { mutableStateOf("") }
//var showCategoryDialog by remember { mutableStateOf(false) }

//
//Column(
//modifier = Modifier
//.fillMaxSize()
//.background(AxWhite)
//) {
//    // 상단 앱바 (Material3 기준)
//    TopBarWithDot(
//        onClickMore = { },
//    )
//    // 상단 검색바
//    TopBarWithSearch(
//        isSearching = isSearching,
//        query = query,
//        onQueryChange = {
//            query = it
//            viewModel.searchProduct(query)
//        },
//        onSearchClick = { isSearching = true },
//        onCloseClick = {
//            isSearching = false
//            query = ""
//            viewModel.getAllProducts()
//        }
//    )
//
//      //BottomSheet 호출예시
//    if (showCategoryDialog) {
//        SampleBottomSheet(
//            showAll = false,
//            categories = categoryList,
//            selectedCategoryId = selectedCategoryId,
//            onCategoryClick = {
//                selectedCategoryId = it?.id
//                showCategoryDialog = false
//            },
//            onDismiss = { showCategoryDialog = false }
//        )
//    }
//
//    Box(
//        modifier = Modifier
//            .weight(1f)
//            .fillMaxWidth()
//    ) {
//
//        when (subscriptions) {
//            is CommonState.Loading -> {
//                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//            }
//
//            is CommonState.Success -> {
//                val subs = (subscriptions as CommonState.Success<List<SubscriptionModel>>).data
//
//                if (subs.isEmpty()) {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            text = "There is no list",
//                            style = MaterialTheme.typography.bodyMedium,
//                            color = Color.Gray
//                        )
//                    }
//                } else {
//                    /* Header*/
//                    SubscriptionSummaryHeader(
//                        subs = subs,
//                        modifier = Modifier
//                            .align(Alignment.TopStart)
//                            .padding(top = 12.dp)
//                    )
//
//                    /* List*/
//                    LazyVerticalStaggeredGrid(
//                        columns = StaggeredGridCells.Fixed(1),
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(top = 127.dp, bottom = 8.dp, start = 4.dp, end = 4.dp),
//                        contentPadding = PaddingValues(4.dp),
//                        verticalItemSpacing = 6.dp,
//                        horizontalArrangement = Arrangement.spacedBy(8.dp)
//                    ) {
//                        items(subs) { sub ->
//                            SubscriptionCard(
//                                subscription = sub,
//                                modifier = Modifier,
//                                onClick = onItemClick,
//                                onDelete = onDeleteClick
//                            )
//                        }
//                    }
//                }
//            }
//
//            is CommonState.Error -> {
//                Text(
//                    text = "Error!",
//                    modifier = Modifier.align(Alignment.Center),
//                    color = Color.Red
//                )
//            }
//        }
//
//        // FAB (Material3 기준)
//        FloatingActionButton(
//            onClick = { onAddClick() },
//            shape = CircleShape,
//            containerColor = AxPrimary,
//            modifier = Modifier
//                .align(Alignment.BottomEnd)
//                .padding(16.dp)
//        ) {
//            Icon(Icons.Filled.Add, contentDescription = "Add", tint = AxWhite)
//        }
//    }
//
////        if (BuildConfig.DEBUG) {
////            Button(
////                onClick = { viewModel.insertDummySubs() },
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(horizontal = 16.dp, vertical = 4.dp)
////            ) {
////                Text("더미 데이터 30개 삽입")
////            }
////        }
//
//    // 하단 고정 배너 광고
//    BannersAds()
//}
