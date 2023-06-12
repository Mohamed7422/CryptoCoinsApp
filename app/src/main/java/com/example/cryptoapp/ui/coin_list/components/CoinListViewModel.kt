package com.example.cryptoapp.ui.coin_list.components


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.common.Resources
 import com.example.cryptoapp.domain.use_case.get_coin.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject  constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {


    private val _state = mutableStateOf(CoinListState())
    var state: State<CoinListState> = _state


    init {
        getCoins()
    }
     private fun getCoins(){
        getCoinsUseCase().onEach { result ->
            when(result){
                //Resources is a generic sealed class to handel states :Success,Error,Loading
                is Resources.Success ->{
                     //modify the state with the result if any
                _state.value = CoinListState(coins = result.data?: emptyList())

                }

                is Resources.Error ->{
                    _state.value = CoinListState(error =
                     result.message?:"Un Expected Error Occurs."
                    )
                }

                is Resources.Loading -> {
                  _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}