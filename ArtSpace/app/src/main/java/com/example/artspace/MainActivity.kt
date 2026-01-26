package com.example.artspace

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentStep by remember { mutableStateOf(1) }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background
    ) {
        val forwardClick: ()-> Unit = {
            currentStep = if (currentStep == 5) 6 else ++currentStep % 6
        }
        val backClick: ()-> Unit = {
            currentStep = if (currentStep == 1) 6 else --currentStep
        }
        when (currentStep) {
            1 -> {
            ArtSpaceLayout(
                drawableResourceId = R.drawable.lion,
                ArtworkTitleResourceId = R.string.artwork_title_1,
                ArtworkArtistYearResourceId = R.string.artwork_artist_year_1,
                onForwardClick = forwardClick,
                onBackClick = backClick
            )
            }
            2 -> {
                ArtSpaceLayout(
                    drawableResourceId = R.drawable.girl,
                    ArtworkTitleResourceId = R.string.artwork_title_2,
                    ArtworkArtistYearResourceId = R.string.artwork_artist_year_2,
                    onForwardClick = forwardClick,
                    onBackClick = backClick
                )
            }
            3 -> {
                ArtSpaceLayout(
                    drawableResourceId = R.drawable.black_boy,
                    ArtworkTitleResourceId = R.string.artwork_title_3,
                    ArtworkArtistYearResourceId = R.string.artwork_artist_year_3,
                    onForwardClick = forwardClick,
                    onBackClick = backClick
                )
            }
            4 -> {
                ArtSpaceLayout(
                    drawableResourceId = R.drawable.eiffel,
                    ArtworkTitleResourceId = R.string.artwork_title_4,
                    ArtworkArtistYearResourceId = R.string.artwork_artist_year_4,
                    onForwardClick = forwardClick,
                    onBackClick = backClick
                )
            }
            5 -> {
                ArtSpaceLayout(
                    drawableResourceId = R.drawable.sunset,
                    ArtworkTitleResourceId = R.string.artwork_title_5,
                    ArtworkArtistYearResourceId = R.string.artwork_artist_year_5,
                    onForwardClick = forwardClick,
                    onBackClick = backClick
                )
            }
            6 -> {
                ArtSpaceLayout(
                    drawableResourceId = R.drawable.ships,
                    ArtworkTitleResourceId = R.string.artwork_title_6,
                    ArtworkArtistYearResourceId = R.string.artwork_artist_year_6,
                    onForwardClick = forwardClick,
                    onBackClick = backClick
                )
            }


        }
    }
}

@Composable
fun ArtSpaceLayout(
    drawableResourceId: Int,
    ArtworkTitleResourceId: Int,
    ArtworkArtistYearResourceId: Int,
    onForwardClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = null,
                modifier = Modifier
                    .width(dimensionResource(R.dimen.button_image_width))
                    .height(dimensionResource(R.dimen.button_image_height))
                    .padding(dimensionResource(R.dimen.button_interior_padding))
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))


                Column(
                    modifier = Modifier
                ) {

                    Text(
                        text = stringResource(ArtworkTitleResourceId),
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Thin,
                        textAlign = TextAlign.Left
                    )
                    Text(
                        text = stringResource(ArtworkArtistYearResourceId),
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left
                    )
                }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))

            Row(
                modifier = Modifier
            ) {

                Button(
                    onClick = onBackClick,
                    shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
                ) {
                    Text(stringResource(R.string.previous), fontSize = 16.sp)
                }
                Button(
                    onClick = onForwardClick,
                    shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
                ) {
                    Text(stringResource(R.string.next), fontSize = 16.sp)
                }
            }


        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}