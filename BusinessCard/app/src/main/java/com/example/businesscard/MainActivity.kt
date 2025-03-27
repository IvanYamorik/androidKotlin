package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.TintAwareDrawable
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    ComposeBusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun ComposeBusinessCardApp() {

Column(
    Modifier
        .fillMaxWidth()
        .background(color = Color(0xBC475D51))

    ) {
    PersonalInfo(
        fullName = stringResource(R.string.name),
        title = stringResource(R.string.profession),
        modifier = Modifier.weight(3f)
    )

    ComposableCard(
        phoneNumber = stringResource(R.string.phone_number),
        socialMedia = stringResource(R.string.s_media),
        email = stringResource(R.string.email),
        modifier = Modifier.weight(1f)
    )

}

}

@Composable
fun PersonalInfo(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier.size(120.dp, 120.dp)
                .background(Color.Black),
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Android logo",
                contentScale = ContentScale.Fit

            )
        }

        Text(
            text = fullName,
            modifier = Modifier
                .width(350.dp)
                .padding(top = 10.dp),
            fontFamily = FontFamily.SansSerif,
            fontSize = 46.sp,
            textAlign = TextAlign.Center

        )

        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFF2B412C),
            modifier = Modifier
                .padding(top = 16.dp)
                .width(350.dp)

        )


    }


}


@Composable
fun ComposableCard(
    phoneNumber: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Box(modifier = Modifier.size(30.dp, 30.dp)) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Phone icon",
                    tint = Color(0xBC232F26),
                )
            }
            Text(
                text = phoneNumber,
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp),
                fontSize = 18.sp,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center

            )
        }
        Row(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Box(modifier = Modifier.size(30.dp, 30.dp)) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Social media icon",
                    tint = Color(0xBC232F26),
                )
            }
            Text(
                text = socialMedia,
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp),
                fontSize = 18.sp,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = Modifier.padding(top = 16.dp, bottom = 32.dp)
        ) {
            Box(modifier = Modifier.size(30.dp, 30.dp)) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email icon",
                tint = Color(0xBC232F26),
            )
           }
            Text(
                text =  email,
                color = Color.Black,
                modifier = Modifier.padding(start = 15.dp),
                fontSize = 18.sp,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center

            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun ComposeBusinessCardAppPreview() {
    BusinessCardTheme {
        ComposeBusinessCardApp()
    }
}