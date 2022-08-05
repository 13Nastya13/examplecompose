package com.example.testcompose.ui.element


import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.ui.model.DataModel
import com.example.testcompose.ui.util.ChartUtil

@Composable
fun ChartAvon(
    modifier: Modifier,
    data: List<DataModel>,
    paddingSpace: Dp
) {

    val dataChart = ChartUtil.getChartMaxsAndStep(data)
    val density = LocalDensity.current

    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.BLACK
            textAlign = Paint.Align.CENTER
            textSize = density.run { 15.sp.toPx() }
        }
    }

    Box(modifier = Modifier.border(BorderStroke(2.dp, Color.Red), RoundedCornerShape(20.dp)),)
    {

        Box(modifier = modifier
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 12.dp),
            contentAlignment = Alignment.Center)
        {
            Canvas(modifier = Modifier.fillMaxSize(),) {

                val yOffset = size.height/(data.size*2)
                val xOffset = size.width/(dataChart.chartCountStep*2)

                val xAxisSpace = (size.width - paddingSpace.toPx()-xOffset) / dataChart.chartCountStep
                val yAxisSpace = size.height / data.size - 10f


                drawLine(
                    start = Offset(x = xOffset, y = 0f),
                    end = Offset(x = xOffset, y = size.height-30),
                    color = Color.Gray
                )

                /** placing points */
                for (i in data.indices) {
                    val rectHeight = 70f
                    val sizeRect = Size(xAxisSpace*(data[i].index/dataChart.chartStep)+xOffset, rectHeight)
                    val y1 = size.height-yAxisSpace*i-rectHeight/2-yOffset

                    drawRoundRect(Color.Magenta,
                        Offset(0f, y1),
                        size = sizeRect,
                        cornerRadius = CornerRadius(10f, 10f))
                }

                drawRect(color = Color.White, size = Size(xOffset, size.height))

                /** placing x axis points */
                var i = 0
                while (i < dataChart.chartCountStep+1) {
                    drawContext.canvas.nativeCanvas.drawText(
                        "${dataChart.chartStep*(i)}",
                        xAxisSpace*i+xOffset,
                        size.height,
                        textPaint
                    )

                    drawLine(
                        start = Offset(x = xAxisSpace*(i)+xOffset, y = 0f),
                        end = Offset(x = xAxisSpace*(i)+xOffset, y = size.height-30),
                        color = Color.Gray
                    )
                    i++
                }

                /** placing y axis points */
                for (i in data.indices) {
                    drawContext.canvas.nativeCanvas.drawText(
                        "${data[i].year}",
                        paddingSpace.toPx()/2f,
                        size.height-yAxisSpace*i-yOffset,
                        textPaint
                    )
                }
            }
        }}
}

@Preview
@Composable
fun previewDiagram()
{
    ChartAvon(modifier = Modifier
        .fillMaxWidth()
        .height(500.dp),
        data = listOf(
//            DataModel(2013,  435f),
//            DataModel(2014,  700f),
//            DataModel(2015,  50f),
//            DataModel(2016,  89f),
            DataModel(2017,  20f),
            DataModel(2018,  75f),
            DataModel(2019,  140f),
            DataModel(2020,  710f),
            DataModel(2021,  25f),
            DataModel(2022,  200f)
        ),
        paddingSpace = 12.dp )
}
