package com.stockminator.equityqueryservice

import com.crazzyghost.alphavantage.AlphaVantage
import com.crazzyghost.alphavantage.Config
import com.crazzyghost.alphavantage.cryptocurrency.Crypto
import com.crazzyghost.alphavantage.exchangerate.ExchangeRate
import com.crazzyghost.alphavantage.forex.Forex
import com.crazzyghost.alphavantage.indicator.Indicator
import com.crazzyghost.alphavantage.sector.Sector
import com.crazzyghost.alphavantage.timeseries.TimeSeries
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration : InitializingBean {

    override fun afterPropertiesSet() {
        val config: Config = Config.builder()
                .key("D66YNYTPLZQPADA7")
                .timeOut(120)
                .build()

        AlphaVantage.api().init(config)
    }

    @Bean
    fun timeSeries(): TimeSeries = AlphaVantage.api().timeSeries()

    @Bean
    fun forex(): Forex = AlphaVantage.api().forex()

    @Bean
    fun exchangeRate(): ExchangeRate = AlphaVantage.api().exchangeRate()

    @Bean
    fun crypto(): Crypto = AlphaVantage.api().crypto()

    @Bean
    fun indicator(): Indicator = AlphaVantage.api().indicator()

    @Bean
    fun sector(): Sector = AlphaVantage.api().sector()
}