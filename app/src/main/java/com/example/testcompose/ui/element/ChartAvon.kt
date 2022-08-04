package com.example.testcompose.ui.element


import android.graphics.Paint
import android.graphics.PointF
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.example.testcompose.ui.DataModel
import kotlin.random.Random

@Composable
fun ChartAvon(
    modifier: Modifier,
    steps: List<Int>,
    data: List<DataModel>,
    paddingSpace: Dp
) {

    var chartMax = 0
    var chartStep = 0
    var chartCountSteps = 0

    var maxData = 0f;
    for (i in data.indices){
        if (data[i].index > maxData){
            maxData = data[i].index
        }
    }

    var strMax = maxData.toString().replaceAfter(".","").replace(".","")
    val tempMax = strMax.subSequence(0,1).toString().toInt()
    chartCountSteps = strMax.length-1

    strMax = (tempMax+1).toString()
    var i = 0
    while (i < chartCountSteps){
        strMax = strMax + "0"
        i++
    }

    chartMax = strMax.toInt()
    chartStep = chartMax/chartCountSteps

    val xOffset = 80f
    val yOffset = 250f
    val density = LocalDensity.current


    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.BLACK
            textAlign = Paint.Align.CENTER
            textSize = density.run { 15.sp.toPx() }
        }
    }

    Box(modifier = modifier
        .background(Color.White)
        .padding(horizontal = 12.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center)
    {
        Canvas(modifier = Modifier.fillMaxSize(),) {
            val xAxisSpace = (size.width - paddingSpace.toPx()-xOffset) / steps.size
            val yAxisSpace = size.height / data.size - 10f

            drawLine(
                start = Offset(x = xOffset, y = 0f),
                end = Offset(x = xOffset, y = size.height-30),
                color = Color.Gray
            )


            /** placing x axis points */
            for (i in steps.indices) {
                drawContext.canvas.nativeCanvas.drawText(
                    "${steps[i]}",
                    xAxisSpace*(i+1)+xOffset,
                    size.height-30f,
                    textPaint
                )

                drawLine(
                    start = Offset(x = xAxisSpace*(i+1)+xOffset, y = 0f),
                    end = Offset(x = xAxisSpace*(i+1)+xOffset, y = size.height-30),
                    color = Color.Gray
                )
            }

            /** placing points */
            for (i in data.indices) {
                val rectHeight = 70f
                val sizeRect = Size(xAxisSpace*(data[i].index/1000)+xOffset, rectHeight)
                val y1 = size.height-yAxisSpace*i-rectHeight/2-yOffset

                drawRoundRect(Color.Magenta,
                    Offset(0f, y1),
                    size = sizeRect,
                    cornerRadius = CornerRadius(10f, 10f))
            }

            drawRect(color = Color.White, size = Size(xOffset, size.height))

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
    }
}

fun getChartMaxsAndStep(list : List<DataModel>, chartMax : Int, chartStep : Int, chartCountSteps : Int) {

}

@Preview
@Composable
fun previewDiagram()
{
    ChartAvon(modifier = Modifier
        .fillMaxWidth()
        .height(500.dp),
        steps = (0..5).map { (it + 1) * 1000 },
        data = listOf(DataModel(2018,  980f),
            DataModel(2019,  1090f), DataModel(2020,  5750f)
            , DataModel(2021,  2500f),  DataModel(2022,  2100f)),
        paddingSpace = 12.dp )
}
