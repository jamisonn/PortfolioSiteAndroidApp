package com.portfoliositeandroidapp

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
actual fun WebViewComponent(
    url: String,
    modifier: Modifier
) {
    // Desktop implementation - placeholder or use JCEF
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "WebView not available on Desktop\nURL: $url",
            color = Color.Gray
        )
    }
}

@Composable
actual fun Modifier.systemBarsPadding(): Modifier {
    return this // No system bars on desktop
}
