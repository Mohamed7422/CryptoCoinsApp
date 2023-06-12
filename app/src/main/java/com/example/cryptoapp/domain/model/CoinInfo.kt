package com.example.cryptoapp.domain.model

import com.example.cryptoapp.data.network.dto.*
import com.google.gson.annotations.SerializedName
import java.text.DateFormatSymbols

data class CoinInfo(

   val coinId:String,
   val name:String,
   val description:String,
   val symbol:String,
   val rank:Int,
   val isActive:Boolean,
   val tags:List<String>,
   val team:List<TeamMember>
)
