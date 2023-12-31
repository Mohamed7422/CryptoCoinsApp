package com.example.cryptoapp.ui.coin_info.components.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.model.CoinInfo
import com.plcoding.cryptocurrencyappyt.ui.theme.ColorPrimary


@Composable
fun CoinTagItem(
    tag:String
){
    Box(modifier = Modifier
        .border(
            width = 1.dp,
            color = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(100.dp)
        )
        .padding(10.dp)
    ){
        Text(
            text =  tag,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body2,

            )
    }
}