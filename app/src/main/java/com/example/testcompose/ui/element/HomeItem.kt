package com.example.testcompose.ui.element

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.testcompose.ui.theme.*

enum class RowType {
    SQUARE
}

@Composable
fun HomeListItem(
    title: String,
    subTitle: String,
    image: String,
    type: RowType,
    onClick: () -> Unit
) {

    val shape = when (type) {
        RowType.SQUARE -> {
            RoundedCornerShape(
                squareRadius,
                squareRadius,
                squareRadius,
                squareRadius)
        }
        else -> {
            RoundedCornerShape(noRadius)
        }
    }
    
    Column {
        Row(
        ) {

        }
        if (type == RowType.SQUARE)
        {
            Divider(
                modifier = Modifier.padding(
                    normalSpace,
                    normalSpace,
                    normalSpace,
                    normalSpace),
                color = Color.White,
                thickness = dividerNormalThickness
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(normalSpace, normalSpace, normalSpace, normalSpace)
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .height(rowHeight)
            .clip(shape)
            .background(color = itemBgColor)
    ) {

        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = "forward",
            modifier = Modifier.align(Alignment.Top)
        )
        Column(Modifier.weight(1f)) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(normalSpace, normalSpace, normalSpace, normalSpace)
            ) {
                Text(title,
                    style = MaterialTheme.typography.subtitle1,
                    color = primaryTextColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
                Spacer(Modifier.height(smallSpace))
                Text(
                    subTitle,
                    style = MaterialTheme.typography.subtitle2,
                    color = primaryTextColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)

            }

        }
        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = "forward",
            modifier = Modifier
                .align(Alignment.Bottom)
                .padding(noSpace, noSpace, noSpace, normalSpace)
        )
        Spacer(Modifier.width(normalRadius))


    }

}

@Preview
@Composable
fun TestSingle() {
    HomeListItem("Item Name", "03/13/21","", RowType.SQUARE, {})
}