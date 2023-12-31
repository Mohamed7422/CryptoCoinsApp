package com.example.cryptoapp.ui.coin_info.components.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptoapp.ui.coin_info.components.CoinInfoViewModel
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun CoinInfoScreen (

    viewModel:CoinInfoViewModel= hiltViewModel()

){
     val state = viewModel.state.value

     Box(modifier = Modifier.fillMaxSize()){
         state.coin?.let {coin ->
             LazyColumn(modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(20.dp)
             ){
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                       Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                           style = MaterialTheme.typography.body1,
                           overflow = TextOverflow.Ellipsis,
                           modifier = Modifier.weight(8f)
                       )

                        Text(
                            text = if (coin.isActive) "active" else "inactive"
                            , color = if (coin.isActive) Color.Green else Color.Red
                            , fontStyle = FontStyle.Italic
                            , textAlign = TextAlign.End
                            , style = MaterialTheme.typography.body2
                            , modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2,
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = "Tags",
                        style = MaterialTheme.typography.h3)

                    Spacer(modifier = Modifier.height(15.dp))

                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        coin.tags.forEach{
                                tag ->
                            CoinTagItem(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "Team members",
                        style = MaterialTheme.typography.body1)

                    Spacer(modifier = Modifier.height(15.dp))

                }
                 items(coin.team){
                     teamMember ->
                     TeamListItem(teamMember = teamMember,
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(10.dp))
                     Divider()
                 }

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