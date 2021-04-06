package com.stockminator.equityqueryservice.alphavantage

import com.crazzyghost.alphavantage.timeseries.TimeSeries
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse
import kotlinx.coroutines.coroutineScope
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@RestController
class Controller(private val timeSeries: TimeSeries) {

    @GetMapping("/hello")
    @ResponseBody
    suspend fun hello(): TimeSeriesResponse = coroutineScope {
        println("hello: " + Thread.currentThread().id)
        timeSeries.intraday().forSymbol("cldr").hack()
    }

    @GetMapping("/bello")
    @ResponseBody
    suspend fun bello(): TimeSeriesResponse = coroutineScope {
        println("hello: " + Thread.currentThread().id)
        timeSeries.intraday().forSymbol("cldr").hack()
    }


    suspend fun <U> TimeSeries.RequestProxy<*, U>.hack(): TimeSeriesResponse =
            suspendCoroutine { continuation ->
                println("suspendCoroutine: " + Thread.currentThread().id)
                onSuccess { value ->
                    println("onSuccess: " + Thread.currentThread().id)
                    continuation.resume(value as TimeSeriesResponse)
                }.fetch()
                println("after fetch: " + Thread.currentThread().id)
            }
}