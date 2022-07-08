package com.example.testcompose.ui.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.R
import com.example.testcompose.ui.theme.*
import org.intellij.lang.annotations.JdkConstants

enum class RowType {
    SQUARE
}

@Composable
fun HomeListItem(
    title: String,
    subTitle: String,
    image: Int,
    editing: Boolean,
    footerText: Boolean,
    type: RowType,
    onClick: () -> Unit
) {
    val shape = when (type) {
        RowType.SQUARE -> {
            RoundedCornerShape(squareRadius, squareRadius, squareRadius, squareRadius)
        }
        else -> {
            RoundedCornerShape(noRadius)
        }
    }
    Card(modifier = Modifier
        .padding(normalSpace, normalSpace, normalSpace, normalSpace)
        .clickable(onClick = onClick)
        .fillMaxWidth(),
        elevation = squareRadius) {
        Column{
            Column(modifier = Modifier.wrapContentHeight()
            ) {
                Row{
                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier.wrapContentHeight()
                    ) {
                        Image(
                            painterResource(id = image),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(smallSpace)
                                .height(iconHeight)
                                .width(iconHeight)
                        )
                    }
                    Column(Modifier.weight(1f)) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.padding(normalSpace, normalSpace, normalSpace, normalSpace)
                        ) {
                            Text(title,
                                style = MaterialTheme.typography.subtitle1,
                                color = primaryTextColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(Modifier.height(smallSpace))
                            Text(
                                subTitle,
                                style = MaterialTheme.typography.subtitle2,
                                color = subTextColor,
                                maxLines = 3,
                                overflow = TextOverflow.Ellipsis,
                                fontFamily = FontFamily.Serif,
                                fontSize = 12.sp)
                        }
                    }
                    Spacer(Modifier.width(normalRadius))
                }
            }
            if (editing) {
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    if (footerText) {
                        Text(text = "START SHOPPINING",
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center,
                            color = homePurple,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = FontFamily.Serif,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "forward",
                        modifier = Modifier
                            .padding(noSpace, noSpace, smallSpace, smallSpace)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TestOrder() {
    HomeListItem("Order tracking", "Track your latest orders by campaign, number, date and value.", R.drawable.tracking_ic, true, false, RowType.SQUARE) {}
}

@Preview
@Composable
fun TestPending() {
    HomeListItem("Pending orders", "Review and approve or reject pending customer orders", R.drawable.ic_pending, false, false, RowType.SQUARE) {}
}

@Preview
@Composable
fun TestBrouchure() {
    HomeListItem("Order tracking", "Track your latest orders by campaign, number, date and value.", R.drawable.ic_brouchure, true, true, RowType.SQUARE) {}
}