package com.portfoliositeandroidapp

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun WebViewComponent(
    url: String,
    modifier: Modifier
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )

                // Enable JavaScript
                settings.javaScriptEnabled = true

                // Set WebViewClient to handle URL loading within the WebView
                webViewClient = WebViewClient()

                // Enable DOM storage (sometimes needed for modern websites)
                settings.domStorageEnabled = true

                // Allow mixed content (HTTP content on HTTPS pages)
                settings.mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            }
        },
        update = { webView ->
            webView.loadUrl(url)
        },
        modifier = modifier
    )
}

@Composable
actual fun Modifier.systemBarsPadding(): Modifier {
    return this
        .statusBarsPadding()
        .navigationBarsPadding()
}

