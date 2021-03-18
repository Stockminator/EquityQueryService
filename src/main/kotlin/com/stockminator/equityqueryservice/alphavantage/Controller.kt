package com.stockminator.equityqueryservice.alphavantage

import com.crazzyghost.alphavantage.timeseries.TimeSeries
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(private val timeSeries: TimeSeries) {

    @GetMapping("/hello")
    @ResponseBody
    suspend fun hello(): TimeSeriesResponse = coroutineScope {
        val timeSeriesResponse: Deferred<TimeSeriesResponse> = async {
            timeSeries.intraday().forSymbol("cldr").fetchSync()
        }
        timeSeriesResponse.await()
    }
}