@file:JvmName("WebsiteActivityKt")

package com.portfoliositeandroidapp

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.portfoliositeandroidapp.ui.theme.portfoliositeandroidappTheme

class WebsiteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            portfoliositeandroidappTheme {
                WebScreen()
            }

        }

    }
}

@Composable
fun WebScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Jamison Portfolio site",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // WebView content area
        WebView()
    }
}

@Composable
fun WebView(){
    // Declare a string that contains a url
    val mUrl = "https://jamisonn.github.io/MainPortfolioSite/"

    // Adding a WebView inside AndroidView
    // with layout to fill remaining space
    AndroidView(
        factory = {
            WebView(it).apply {
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
        update = {
            it.loadUrl(mUrl)
        },
        modifier = Modifier.fillMaxSize()
    )
}