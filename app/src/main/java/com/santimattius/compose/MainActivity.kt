package com.santimattius.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.santimattius.compose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootContainer()
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RootContainer()
}

@Composable
fun RootContainer() {
    JetpackComposeTheme {
        Scaffold(
            topBar = {
                TopAppBar({ Text(text = stringResource(R.string.title_programmers)) })
            },
            content = {
                LazyColumn(
                    Modifier.padding(start = 16.dp, end = 16.dp)
                ) {
                    items(items = DataProvider.programmers, key = { it.id }) { programmer ->
                        ProgrammerRow(programmer = programmer)
                    }
                }
            }
        )
    }
}

@Composable
fun ProgrammerRow(programmer: Programmer) {
    Row(
        modifier = Modifier.padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_account),
            contentDescription = "Programmer Avatar",
            modifier = Modifier.padding(8.dp)
        )
        Column {
            Text(programmer.name)
            Text(programmer.languages)
        }
    }
}





