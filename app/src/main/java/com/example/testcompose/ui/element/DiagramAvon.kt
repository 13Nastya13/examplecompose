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
import androidx.compose.ui.geometry.Offset
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
fun DiagramAvon(
    modifier: Modifier,

    years: List<Int>,
    steps: List<Int>,
    data: List<DataModel>,
    paddingSpace: Dp,
    verticalStep: Int
) {

    val controlPoints1 = mutableListOf<PointF>()
    val controlPoints2 = mutableListOf<PointF>()
    val coordinates = mutableListOf<PointF>()
    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.BLACK
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Box(modifier = modifier
        .background(Color.White)
        .padding(horizontal = 8.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center)
    {
        Canvas(modifier = Modifier.fillMaxSize(),) {
            val xAxisSpace = (size.width - paddingSpace.toPx()) / steps.size
            val yAxisSpace = size.height / years.size


            /** placing x axis points */
            for (i in steps.indices) {
                drawContext.canvas.nativeCanvas.drawText(
                    "${steps[i]}",
                    xAxisSpace*(i+1),
                    size.height-30,
                    textPaint
                )
            }

            /** placing y axis points */
            for (i in years.indices) {
                drawContext.canvas.nativeCanvas.drawText(
                    "${years[i]}",
                    paddingSpace.toPx()/2f,
                    size.height-yAxisSpace*(i + 1),
                    textPaint
                )
            }

//            val x1 = xAxisSpace * xValues[i]
//            val y1 = size.height - (yAxisSpace * (points[i]/verticalStep.toFloat()))
            /** placing points */
            for (i in data.indices) {
                val x1 = xAxisSpace * i
                val y1 = size.height - (yAxisSpace * (data[i].year/verticalStep.toFloat()))
                coordinates.add(PointF(x1,y1))
                drawCircle(
                    color = Color.Green,
                    radius = 10f,
                    center = Offset(x1,y1)
                )
            }


        }
    }

}

@Preview
@Composable
fun previewDiagram()
{

    val yStep = 50
    val random = Random
    /* to test with random points */
    val points = (0..9).map {
        var num = random.nextInt(350)
        if (num <= 50)
            num += 100
        num.toFloat()
    }

    DiagramAvon(modifier = Modifier
        .fillMaxWidth()
        .height(500.dp),
        years = (2018..2021).map { it + 1 },
        steps = (0..5).map { (it + 1) * 1000 },
        data = (0..4).map { DataModel(it+2018, (it + 1) * 1000) },
        paddingSpace = 16.dp,
        verticalStep = yStep )
}

//xValues = (0..9).map { it + 1 },
//yValues = (0..6).map { (it + 1) * yStep },
//val points = listOf(150f,100f,250f,200f,330f,300f,90f,120f,285f,199f),