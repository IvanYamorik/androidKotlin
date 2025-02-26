package com.example.articles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articles.ui.theme.ArticlesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticlesTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    MainImage(
                        title = stringResource(R.string.tutorialTitle),
                        article1 = stringResource(R.string.article1Content),
                        article2 = stringResource(R.string.article2Content)

                    )
                }
            }
        }
    }
}

@Composable
fun TextContent(title: String, article1: String, article2: String, modifier: Modifier = Modifier) {

    Column(
        //verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(all = 16.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = article1,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(1f),
            textAlign = TextAlign.Justify
        )

        Text(
        text = article2,
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(1f),
        color = Color.Unspecified,
        fontSize = TextUnit.Unspecified,
        fontStyle = null,
        fontWeight = null,
        fontFamily = null,
        letterSpacing = TextUnit.Unspecified,
        textDecoration = null,
            textAlign = TextAlign.Justify,
        lineHeight = TextUnit.Unspecified,
        overflow = TextOverflow.Clip,
        softWrap = true,
        maxLines = Int.MAX_VALUE,
        minLines = 1,
        onTextLayout = null,
        style = LocalTextStyle.current
        )
    }
}

@Composable
fun MainImage(title: String, article1: String, article2: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.articles_background)

    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.height(110.dp)
        )


        Box {
            TextContent(
                title = title,
                article1 = article1,
                article2 = article2,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }

}



@Preview(showBackground = true)
@Composable
fun ArticlesPreview() {
    ArticlesTheme {
        MainImage(
            title = stringResource(R.string.tutorialTitle),
            article1 = stringResource(R.string.article1Content),
            article2 = stringResource(R.string.article2Content)
        )
    }
}