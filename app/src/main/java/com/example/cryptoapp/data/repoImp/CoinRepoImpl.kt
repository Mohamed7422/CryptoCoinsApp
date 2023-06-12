package com.example.cryptoapp.data.repoImp

import com.example.cryptoapp.data.network.CoinPaprikaApi
import com.example.cryptoapp.data.network.dto.CoinDto
import com.example.cryptoapp.data.network.dto.CoinInfoDto
import com.example.cryptoapp.domain.repo.CoinRepo
import javax.inject.Inject

class CoinRepoImpl @Inject  constructor(
    private val  api: CoinPaprikaApi
) : CoinRepo{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoins(coinId: String): CoinInfoDto {
        return api.getCoinById(coinId)
    }


}
