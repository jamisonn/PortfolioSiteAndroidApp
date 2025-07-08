package com.portfoliositeandroidapp


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.WebKit.WKWebView
import platform.UIKit.UIView
import androidx.compose.ui.interop.UIKitView

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun WebViewComponent(
    url: String,
    modifier: Modifier
) {
    UIKitView(
        factory = {
            val webView = WKWebView()
            val nsUrl = NSURL.URLWithString(url)
            val request = NSURLRequest.requestWithURL(nsUrl!!)
            webView.loadRequest(request)
            webView
        },
        modifier = modifier
    )
}

@Composable
actual fun Modifier.systemBarsPadding(): Modifier {
    return this.safeDrawingPadding()
}
