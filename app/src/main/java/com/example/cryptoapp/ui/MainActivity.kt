package com.example.cryptoapp.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptoapp.common.Resources
import com.example.cryptoapp.ui.coin_info.components.components.CoinInfoScreen
import com.example.cryptoapp.ui.coin_list.components.components.CoinListScreen
import com.plcoding.cryptocurrencyappyt.ui.theme.CryptoApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContent{
          CryptoApp{
              Surface( color = MaterialTheme.colors.background) {
               val navController = rememberNavController()
                  NavHost(
                      navController = navController,
                      startDestination = Screen.CoinListScreen.route ){
                      composable(
                          route = Screen.CoinListScreen.route
                      ){
                          CoinListScreen(navController)
                      }
                      composable(
                          route = Screen.CoinInfoScreen.route + "/{coinId}"
                      ){
                          CoinInfoScreen()
                      }
                  }
              }
          }
      }

    }
}