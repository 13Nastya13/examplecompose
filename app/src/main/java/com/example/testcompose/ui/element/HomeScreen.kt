package com.example.testcompose.ui.element

import android.widget.ScrollView
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.testcompose.R
import com.example.testcompose.ui.theme.*

@Composable
fun HomeScreen(countDays : String,
               campaign : String) {
    Column() {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(headerHeight)
                .background(Color.White)
                .fillMaxWidth()) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "forward",
                modifier = Modifier.weight(1f)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                .weight(7f)) {

                Text(text = "Manage your orders",
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.Serif,
                    color = primaryTextColor,
                    fontSize = 21.sp)

            }
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "forward",
                modifier = Modifier.weight(1f)
            )
        }
        Box()
        {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(homePurple),) {
                }
                Row(modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()) {
                }
            }
            Surface(
                modifier = Modifier.fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                color = Color.Transparent
            ) {
                Column {
                    Text(text = "$countDays days left in Campaign $campaign",
                        modifier = Modifier
                            .padding(normalSpace, smallSpace, normalSpace, smallSpace)
                            .align(
                                Alignment.CenterHorizontally
                            ),
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily.Serif,
                        color = Color.White,
                        fontSize = 15.sp)
                    HomeListItem("Order tracking",
                        "Track your latest orders by campaign, number, date and value.",
                        R.drawable.tracking_ic,
                        true,
                        false,
                        RowType.SQUARE) {}
                    HomeListItem("Pending orders",
                        "Review and approve or reject pending customer orders",
                        R.drawable.ic_pending,
                        false,
                        false,
                        RowType.SQUARE) {}
                    HomeListItem("Return order",
                        "Return your order by clicking here",
                        R.drawable.ic_return,
                        true,
                        false,
                        RowType.SQUARE) {}
                    Column{
                        Text(text = "Place a new order",
                            modifier = Modifier.padding(normalSpace, smallSpace, normalSpace, smallSpace),
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = FontFamily.Serif,
                            color = primaryTextColor,
                            fontSize = 21.sp)
                        Text(text = "Choose your favourite way",
                            modifier = Modifier.padding(normalSpace, smallSpace, normalSpace, smallSpace),
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = FontFamily.Serif,
                            color = subTextColor,
                            fontSize = 15.sp)
                    }
                    HomeListItem("Avon Brochure",
                        "Now you can browse your digital brouchure to add items to your order and save them for submission.",
                        R.drawable.ic_brouchure,
                        true,
                        true,
                        RowType.SQUARE) {}
                }
            }
        }
    }
}

@Preview
@Composable
fun TestHomeScreen() {
    HomeScreen("7","A")
}