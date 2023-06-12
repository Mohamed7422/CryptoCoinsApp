package com.example.cryptoapp.ui.coin_info.components


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.common.Constants
import com.example.cryptoapp.common.Resources
import com.example.cryptoapp.domain.use_case.get_coins.GetCoinByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinInfoViewModel @Inject  constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

//    private val _sss = snapshotFlow{CoinInfoState()}
//    val ss : Flow<CoinInfoState> = _sss
     private val _state = mutableStateOf(CoinInfoState())
     val state : State<CoinInfoState> = _state



    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoins(coinId)

        }
    }
    //handle the logic
    //what part of UI state should change!
    //why it's changed!
    //why it's should change!
     private fun getCoins(coinId: String) {
         //pass the id to getCoinById to get response
         //so we made a loop on each item
         //and in case of the success - > updating the state
         //loading -> set loading to show progress circle
        getCoinByIdUseCase(coinId).onEach { result ->
            when(result){
                is Resources.Success ->{

                _state.value = CoinInfoState(coin = result.data )

                }

                is Resources.Error ->{
                    _state.value = CoinInfoState(error =
                     result.message?:"Un Expected Error Occurs."
                    )
                }

                is Resources.Loading -> {
                  _state.value = CoinInfoState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}