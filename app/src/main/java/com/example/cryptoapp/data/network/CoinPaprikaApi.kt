package com.example.cryptoapp.data.network

import com.example.cryptoapp.common.Resources
import com.example.cryptoapp.data.network.dto.CoinDto
import com.example.cryptoapp.data.network.dto.CoinInfoDto
import com.example.cryptoapp.domain.model.CoinInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String): CoinInfoDto

}