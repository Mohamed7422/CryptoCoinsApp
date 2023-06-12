package com.example.cryptoapp.ui.coin_info.components

import com.example.cryptoapp.domain.model.CoinInfo

data class CoinInfoState(

    val isLoading:Boolean= false,
    val coin: CoinInfo?=null,
    val error: String=""
)
