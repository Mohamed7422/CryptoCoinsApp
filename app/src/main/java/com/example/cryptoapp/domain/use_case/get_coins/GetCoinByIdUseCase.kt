package com.example.cryptoapp.domain.use_case.get_coins

import android.annotation.SuppressLint
import com.example.cryptoapp.common.Resources
import com.example.cryptoapp.data.network.dto.toCoin
import com.example.cryptoapp.data.network.dto.toCoinInfo
import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.model.CoinInfo
import com.example.cryptoapp.domain.repo.CoinRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

//this is a primary constructor
 class GetCoinByIdUseCase @Inject constructor(
    private val repository: CoinRepo
 ) {
    @SuppressLint("SuspiciousIndentation")
    operator fun invoke(coinId:String): Flow<Resources<CoinInfo>> = flow {
         try {
            emit(Resources.Loading<CoinInfo>())
           val coins= repository.getCoins(coinId).toCoinInfo()
             emit(Resources.Success<CoinInfo>(coins))
         }catch (e:HttpException){
              emit(Resources.Error<CoinInfo>(e.localizedMessage?:"Unexpected Error"))
         }catch (e:IOException){
             emit(Resources.Error<CoinInfo>(e.localizedMessage?:"check internet connection"))
         }
     }

 }