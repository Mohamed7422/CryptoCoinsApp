package com.example.cryptoapp.domain.repo

import com.example.cryptoapp.data.network.dto.CoinDto
import com.example.cryptoapp.data.network.dto.CoinInfoDto

interface CoinRepo {

    suspend fun getCoins() : List<CoinDto>


    suspend fun getCoins(coinId:String) : CoinInfoDto
}