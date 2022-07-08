package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testcompose.ui.element.HomeListItem
import com.example.testcompose.ui.element.HomeScreen
import com.example.testcompose.ui.element.RowType
import com.example.testcompose.ui.theme.TESTCOMPOSETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TESTCOMPOSETheme {
                // A surface container using the 'background' color from the theme
                HomeScreen(countDays = "9", campaign = "A" )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TESTCOMPOSETheme {
        HomeScreen(countDays = "9", campaign = "A")
    }
}