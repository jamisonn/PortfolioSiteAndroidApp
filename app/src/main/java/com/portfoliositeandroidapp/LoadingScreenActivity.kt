package com.portfoliositeandroidapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.portfoliositeandroidapp.ui.theme.portfoliositeandroidappTheme

class LoadingScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            portfoliositeandroidappTheme {
                LoadingScreen( onTimeout = {
                    val navigate = Intent(this@LoadingScreenActivity, WebsiteActivity::class.java)
                    startActivity(navigate)
                    finish() // optional: close LoadingScreenActivity so user can't go back to it)


                    })
        }
    }
}

@Composable
fun LoadingScreen(onTimeout: () -> Unit) {
    // Launch side-effect when this composable enters the composition
    androidx.compose.runtime.LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(10_000L) // wait 10 seconds
        onTimeout()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Logo(
                modifier = Modifier.size(214.dp)
            )


            ProgressBar(
                modifier = Modifier.size(210.dp)
            )
        }

    }

}

@Composable
fun ProgressBar(modifier: Modifier = Modifier) {

    CircularProgressIndicator(
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant)

}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.loadingscreen),
        contentDescription = stringResource(id = R.string.Logo),
        modifier = modifier
    )
}}



