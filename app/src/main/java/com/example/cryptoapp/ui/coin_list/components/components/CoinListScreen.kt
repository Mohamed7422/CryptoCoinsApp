package com.example.cryptoapp.ui.coin_list.components.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptoapp.ui.Screen
import com.example.cryptoapp.ui.coin_list.components.CoinListViewModel


@Composable
fun CoinListScreen (
    navController:NavController,
    viewModel:CoinListViewModel= hiltViewModel()

){
     val state = viewModel.state.value
       
     Box(modifier = Modifier.fillMaxSize()){
         LazyColumn(modifier = Modifier.fillMaxSize()){
             items(state.coins){
                     coin ->
                 CoinListItem(
                     coin = coin,
                     onItemClick = {
                         navController.navigate(Screen.CoinInfoScreen.route+"/${coin.id}")
                     }

                 )
             }

         }
         if (state.error.isNotBlank()){
             Text(
                 text = state.error,
                 color = MaterialTheme.colors.error,
                 textAlign = TextAlign.Center,
                 modifier = Modifier
                     .fillMaxSize()
                     .padding(horizontal = 20.dp)
                     .align(Alignment.Center)
             )
         }

         if(state.isLoading){
             CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
         }

     }
}