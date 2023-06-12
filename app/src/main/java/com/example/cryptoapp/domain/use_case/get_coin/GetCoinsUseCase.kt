package com.example.cryptoapp.domain.use_case.get_coin

import com.example.cryptoapp.common.Resources
import com.example.cryptoapp.data.network.dto.toCoin
import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.repo.CoinRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repo: CoinRepo
) {
     operator fun invoke():Flow<Resources<List<Coin>>> = flow {

         try{
            emit(Resources.Loading<List<Coin>>())
            val coins = repo.getCoins().map { it.toCoin() }
            emit(Resources.Success<List<Coin>>(coins))
         }catch (e: HttpException){
             emit(Resources.Error<List<Coin>>(e.localizedMessage?:"An Unexpected Error."))
         }catch (e:IOException){
              emit(Resources.Error<List<Coin>>( "Check internetConnection."))
         }




     }

}