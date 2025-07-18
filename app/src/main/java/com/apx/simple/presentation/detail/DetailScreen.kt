package com.apx.simple.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.apx.simple.presentation.ui.theme.AxWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AxWhite)
    ) {
        Text(text = "DETAIL SCREEN")
    }
}
