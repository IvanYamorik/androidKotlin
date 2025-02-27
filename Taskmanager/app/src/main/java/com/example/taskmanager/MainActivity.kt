package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainImage(
                        line1 = stringResource(R.string.tasks_completion),
                        praise = stringResource(R.string.evaluation)
                    )

                }
            }
        }
    }
}

@Composable
fun SuccessText(line1: String, praise: String, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = line1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = praise,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,

        )
    }
}

@Composable
fun MainImage(line1: String, praise: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)

    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(370.dp),
            alignment = Alignment.Center,


        )
        SuccessText(
            line1 = line1,
            praise = praise,
            modifier = Modifier.size(370.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
            MainImage(
                line1 = stringResource(R.string.tasks_completion),
                praise = stringResource(R.string.evaluation)
            )
    }
}