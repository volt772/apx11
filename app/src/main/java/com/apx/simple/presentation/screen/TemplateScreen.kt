package com.apx.simple.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.apx.simple.presentation.ui.theme.AxRed500

@Composable
fun TemplateScreen(
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "템플릿스크린",
            color = AxRed500,
            style = MaterialTheme.typography.titleMedium
        )
    }
}
