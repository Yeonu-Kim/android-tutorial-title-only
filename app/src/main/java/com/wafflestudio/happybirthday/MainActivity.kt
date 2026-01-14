package com.wafflestudio.happybirthday

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wafflestudio.happybirthday.ui.theme.HappyBirthdayTheme

val titleList = listOf(
    "Text composable",
    "Image composable",
    "Row composable",
    "Column composable"
)
val contentList = listOf(
    "Displays text and follows the recommended Material Design guidelines.",
    "Creates a composable that lays out and draws a given Painter class object.",
    "A layout composable that places its children in a horizontal sequence.",
    "A layout composable that places its children in a vertical sequence."
)
val colorList = listOf(
    Color(0xFFEADDFF),
    Color(0xFFD0BCFF),
    Color(0xFFB69DF8),
    Color(0xFFF6EDFF)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FourSectionContainer(
                        titleList = titleList,
                        contentList = contentList,
                        colorList = colorList
                    )
                }
            }
        }
    }
}

@Composable
fun ContentContainer(title: String, content: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier=modifier
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
        )
    }
}
@Composable
fun FourSectionContainer(
    titleList: List<String>,
    contentList: List<String>,
    colorList: List<Color>,
    modifier: Modifier = Modifier
) {
    Column(modifier=modifier.fillMaxSize()) {
        Row(modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
        ) {
            ContentContainer(
                title = titleList[0],
                content = contentList[0],
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(colorList[0])
            )
            ContentContainer(
                title = titleList[1],
                content = contentList[1],
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(colorList[1])
            )
        }
        Row(modifier = modifier
            .fillMaxWidth()
            .weight(1f)
        ) {
            ContentContainer(
                title = titleList[2],
                content = contentList[2],
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(colorList[2])
            )
            ContentContainer(
                title = titleList[3],
                content = contentList[3],
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(colorList[3])
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckPreview() {
    HappyBirthdayTheme {
        FourSectionContainer(
            titleList = titleList,
            contentList = contentList,
            colorList = colorList
        )
    }
}
