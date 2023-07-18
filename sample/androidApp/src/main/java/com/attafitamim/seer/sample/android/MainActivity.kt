package com.attafitamim.seer.sample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.attafitamim.seer.libs.core.facade.Seer
import com.attafitamim.seer.libs.core.model.LogLevel
import com.attafitamim.seer.libs.core.model.LogParameter
import com.attafitamim.seer.sample.Greeting
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }
        }

        logSomeStuff()
    }

    private fun logSomeStuff() {
        GlobalScope.launch {
            repeat(10) { index ->
                Seer.log(
                    "LOG_TAG_$index",
                    LogLevel.ERROR,
                    description = "This is some log",
                    jsonPayload = "{ \"index\": $index }",
                )

                delay(1000)
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
