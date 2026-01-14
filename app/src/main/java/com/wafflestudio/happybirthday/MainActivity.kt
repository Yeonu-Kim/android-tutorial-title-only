package com.wafflestudio.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wafflestudio.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val title = getString(R.string.title)  // 단일 문자열
        val contentList = resources.getStringArray(R.array.content_list).toList()  // 문자열 배열
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    News(title=title, content=contentList)
                }
            }
        }
    }
}

@Composable
fun News(title: String, content: List<String>, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier=modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        NewsContent(
            title=title,
            content=content,
        )
    }
}

@Composable
fun NewsContent(title: String, content: List<String>, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier=modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 8.dp
                )
        )
        content.forEach {
            item -> Text(
                text = item,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun NewsContentPreview() {
    val title = stringResource(R.string.title)
    val context = LocalContext.current
    val contentList = context.resources.getStringArray(R.array.content_list).toList()

    HappyBirthdayTheme {
        NewsContent(title, contentList)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsPreview() {
    val title = stringResource(R.string.title)
    val context = LocalContext.current
    // TODO: Warning 없이 사용하는 방법?
    val contentList = context.resources.getStringArray(R.array.content_list).toList()

    HappyBirthdayTheme {
        News(title, contentList)
    }
}