package com.attafitamim.seer.sample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.attafitamim.seer.core.domain.model.log.LogEntry
import com.attafitamim.seer.core.domain.model.log.LogLevel
import com.attafitamim.seer.core.domain.model.log.LogParameter
import java.util.UUID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val logEntry = LogEntry(
                        id = UUID.randomUUID().toString(),
                        dateInMillis = System.currentTimeMillis(),
                        tag = "TAG",
                        level = LogLevel.DEBUG,
                        description = "This is some log from Android",
                        parameters = listOf(LogParameter("testParameter", "Some Value")),
                        jsonPayload = "{\"testField\":\"Test Value\"}",
                        note = "Some note for log entry",
                        isBookmarked = false
                    )

                    GreetingView(logEntry.toString())
                }
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
