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
    // Web implementation - could use iframe or redirect
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Web implementation\nRedirecting to: $url",
            color = Color.Blue
        )
    }
}

@Composable
actual fun Modifier.systemBarsPadding(): Modifier {
    return this // No system bars on web
}
