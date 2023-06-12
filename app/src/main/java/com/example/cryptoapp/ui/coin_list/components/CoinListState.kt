package com.example.cryptoapp.ui.coin_list.components

import com.example.cryptoapp.domain.model.Coin

data class CoinListState(

    val isLoading:Boolean= false,
    val coins: List<Coin> = emptyList(),
    val error: String=""
)
