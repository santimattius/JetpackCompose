package com.santimattius.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
                LazyColumn {
                    items(
                        items = DataProvider.programmers,
                        key = {
                            it.id
                        }) { programmer ->
                        Text(text = programmer.name)
                    }
                }
            }
        )
    }
}

@Composable
fun TopAppBar() {
    TopAppBar(
        title = { Text(text = "AppBar") },
        navigationIcon = {

        },
    )
}




