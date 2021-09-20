package com.sharvari.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sharvari.splash.ui.theme.SplashTheme

class SplashActivity : ComponentActivity() {

    private val splashDelay = 2000F;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashTheme{
                SplashTitle()

                var intent = Intent(this@SplashActivity, MainActivity::class.java)
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(intent)
                }, splashDelay.toLong())
            }
        }
    }
}

@Composable
fun SplashTitle() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_700)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "The Coder Buddy",
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewSplash() {
    SplashTheme {
        SplashTitle()
    }
}