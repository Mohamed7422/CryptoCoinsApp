package com.example.cryptoapp.ui

import androidx.annotation.StringRes

sealed class Screen(val route: String){

    object CoinListScreen: Screen("coin_list")
    object CoinInfoScreen: Screen("coin_info")

}
