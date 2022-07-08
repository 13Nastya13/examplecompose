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
import com.example.testcompose.ui.element.RowType
import com.example.testcompose.ui.theme.TESTCOMPOSETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TESTCOMPOSETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        HomeListItem("Order tracking", "Track your latest orders by campaign, number, date and value.", R.drawable.tracking_ic, true, RowType.SQUARE) {}
                        HomeListItem("Pending orders", "Review and approve or reject pending customer orders", R.drawable.tracking_ic, false, RowType.SQUARE) {}

                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TESTCOMPOSETheme {
        Column() {
            HomeListItem("Order tracking", "Track your latest orders by campaign, number, date and value.", R.drawable.tracking_ic, true, RowType.SQUARE) {}
            HomeListItem("Pending orders", "Review and approve or reject pending customer orders", R.drawable.tracking_ic, false, RowType.SQUARE) {}
            HomeListItem("Order tracking", "Track your latest orders by campaign, number, date and value.", R.drawable.tracking_ic, true, RowType.SQUARE) {}

        }
    }
}