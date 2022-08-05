package com.example.testcompose.ui.util

import com.example.testcompose.ui.model.ChartData
import com.example.testcompose.ui.model.DataModel

class ChartUtil {

    companion object {

        fun getChartMaxsAndStep(data : List<DataModel>) : ChartData {
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
            val maxLength = strMax.length - 1
            val tempMax = strMax.subSequence(0,1).toString().toInt()
            chartCountSteps = tempMax + 1

            strMax = (tempMax+1).toString()
            var i = 0
            while (i < maxLength){
                strMax = strMax + "0"
                i++
            }

            chartMax = strMax.toInt()
            chartStep = chartMax/chartCountSteps

            return ChartData(chartMax,chartStep,chartCountSteps)
        }
    }
}